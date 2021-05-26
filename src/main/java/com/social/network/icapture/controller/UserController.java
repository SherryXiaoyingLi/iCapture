package com.social.network.icapture.controller;


import com.social.network.icapture.security.CustomUserDetails;
import com.social.network.icapture.model.User;
import com.social.network.icapture.security.JwtTokenService;
import com.social.network.icapture.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private Logger logger;


    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@Valid @RequestBody User user) {
        logger.info(String.format("Getting new user: %s", user.toString()));
        String jwt = jwtTokenService.generateToken(
                new CustomUserDetails(userService.signUp(user)));
        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }


    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(), user.getPassword()));

        String jwt = jwtTokenService.generateToken(
                userService.loadUserByUsername(user.getUsername()));
        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }

    @PostMapping(value = "/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String token = (String) authentication.getCredentials();
        jwtTokenService.setTokenExpired(token);
    }

    @GetMapping(value = "/test")
    public String test() {
        return "test sent back string result";
    }
}
