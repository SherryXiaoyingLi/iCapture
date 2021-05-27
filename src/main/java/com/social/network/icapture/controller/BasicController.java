package com.social.network.icapture.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{userId}")
@Validated
public class BasicController {

//    @Autowired
//    UserService userService;

//    @GetMapping("/greetings/{username}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public String Hello(@PathVariable String username) {
//        return "Hello, nice to meet you " + username;
//    }

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

//    @GetMapping(value = "/")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public User getUser(@PathVariable @NotNull long userId) {
//        // verify authentication first
//        return userService.getUser(userId);
//    }


}
