package com.example.empik.githubapiservice.model.cdm;

import java.util.Date;

public class UserInfo {

    private Long id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private Date createdAt;
    private double calculations;


    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getAvatarUrl() {
        return avatarUrl;
    }
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public double getCalculations() {
        return calculations;
    }
    public void setCalculations(double calculations) {
        this.calculations = calculations;
    }
}
