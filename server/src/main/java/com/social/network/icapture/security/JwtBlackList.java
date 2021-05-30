package com.social.network.icapture.security;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "jwtBlackList")
public class JwtBlackList {

    @Id
    private String token;

    public JwtBlackList(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
