package com.priming.reactive.dto;

public class UserInfoResponse {
    private String token;

    private String type;

    private String email;

    public UserInfoResponse(String token) {
        this.token = token;
    }
}
