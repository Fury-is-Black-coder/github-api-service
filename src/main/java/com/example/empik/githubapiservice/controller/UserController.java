package com.example.empik.githubapiservice.controller;

import com.example.empik.githubapiservice.business.UserService;
import com.example.empik.githubapiservice.model.cdm.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{login}")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable String login) {
        UserInfo userInfo = userService.getUserInfo(login);
        return ResponseEntity.ok(userInfo);
    }

}
