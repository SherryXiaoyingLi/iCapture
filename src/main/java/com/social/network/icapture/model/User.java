package com.social.network.icapture.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Document(collection = "user")
public class User {

    @Id
    @NotNull
    private long userId;

    @NotNull
    @Size(min=2, max=10)
    @Pattern(regexp="^[A-Za-z \\s\\-]*$")
    private String username;

    @NotNull
    @Size(min=10, max=15)
    private String password;

    private String website;
    private String bio;


    public User(long userId, String username, String password,
                String website, String bio) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.website = website;
        this.bio = bio;
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getWebsite() {
        return website;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public String toString() {
        return String.format("User(userId=%d, username='%s', password=***, website='%s', bio='%s')",
                userId, username, password, website, bio);
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
