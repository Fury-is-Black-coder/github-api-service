package com.example.empik.githubapiservice.business;

import com.example.empik.githubapiservice.model.cdm.GitHubUserApiResponse;
import com.example.empik.githubapiservice.model.cdm.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ExternalApiService {

    private static final String GITHUB_API_URL = "https://api.github.com/users/";

    @Autowired
    private WebClient.Builder webClientBuilder;

    public UserInfo fetchUserInfo(String login) {
        String apiUrl = GITHUB_API_URL + login;

        Mono<GitHubUserApiResponse> responseMono = webClientBuilder.build()
                .get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(GitHubUserApiResponse.class);

        GitHubUserApiResponse response = responseMono.block(); // Blokuj i czekaj na odpowiedź

        System.out.println("GitHubUserApiResponse getLogin:"+response.getLogin()
                +" getId:"+response.getId()
                +" getName:"+response.getName()
                +" getType:"+response.getType()
                +" getAvatarUrl:"+response.getAvatarUrl()
                +" getCreatedAt: "+response.getCreatedAt()
                +" getFollowers:"+response.getFollowers()
                +" getPublicRepos:"+response.getPublicRepos());

        //Mapping
        UserInfo userInfo = new UserInfo();
        userInfo.setId(response.getId());
        userInfo.setLogin(response.getLogin());
        userInfo.setName(response.getName());
        userInfo.setType(response.getType());
        userInfo.setAvatarUrl(response.getAvatarUrl());
        userInfo.setCreatedAt(response.getCreatedAt());
        userInfo.setCalculations(6.0 / response.getFollowers() * (2 + response.getPublicRepos()));

        return userInfo;
    }
}