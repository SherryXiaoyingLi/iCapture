package com.social.network.icapture.exception;


import com.social.network.icapture.model.User;

public class UserAlreadyExistsException extends RuntimeException {

    private String message;

    public UserAlreadyExistsException(User user) {
        this.message = String.format(
                "UserAlreadyExistsException thrown: username %s", user.getUsername());
    }

    public String getMessage() {
        return message;
    }

}
