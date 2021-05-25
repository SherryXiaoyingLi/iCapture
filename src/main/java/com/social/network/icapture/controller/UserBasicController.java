package com.social.network.icapture.controller;

import com.social.network.icapture.model.User;
import com.social.network.icapture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/users/{userId}")
@Validated
public class UserBasicController {

    @Autowired
    UserService userService;

    @GetMapping("/greetings/{username}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String Hello(@PathVariable String username) {
        return "Hello, nice to meet you " + username;
    }

//    @PostMapping("/*.png")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void uploadPicture(@RequestBody String body) {
//        System.out.println("received request");
//    }

//    @GetMapping(value = "/{id}/*.png", params = "id=1")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void uploadPicture(@PathVariable int id) {
//        System.out.println("received request");
//    }

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User getUser(@PathVariable @NotNull long userId) {
        // verify authentication first
        return userService.getUser(userId);
    }


}
