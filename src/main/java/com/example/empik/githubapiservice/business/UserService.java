package com.example.empik.githubapiservice.business;

import com.example.empik.githubapiservice.dao.UserRepository;
import com.example.empik.githubapiservice.model.cdm.UserInfo;
import com.example.empik.githubapiservice.model.entity.GitHubApiRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExternalApiService externalApiService;

    public UserInfo getUserInfo(String login) {
        UserInfo userInfo = externalApiService.fetchUserInfo(login);

        // user exists in the database
        Optional<GitHubApiRequests> existingUser = userRepository.findByLogin(login);

        if (existingUser.isPresent()) {
            // If the user exists, increase REQUEST_COUN
            userRepository.incrementRequestCount(login);
        } else {
            // If the user does not exist, add him to the database
            GitHubApiRequests newUser = new GitHubApiRequests();
            newUser.setLogin(login);
            newUser.setRequestCount(1);
            userRepository.save(newUser);
        }

        return userInfo;
    }

}
