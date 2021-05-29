package com.social.network.icapture.model;

public class AuthenticationResponse {

    private User user;
    private String token;

    public AuthenticationResponse(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }
}
