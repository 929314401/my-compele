package com.user.dubbo.dto;

public class UserInfo extends User {
    private String token;

    public UserInfo(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {

        this.token = token;
    }

}
