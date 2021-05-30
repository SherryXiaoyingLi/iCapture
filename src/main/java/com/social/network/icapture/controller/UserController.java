package com.social.network.icapture.controller;


import com.social.network.icapture.model.AuthenticationRequest;
import com.social.network.icapture.model.AuthenticationResponse;
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
    public ResponseEntity<Object> register(@Valid @RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = userService.handleRegistrationRequest(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody AuthenticationRequest request) {
        authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword()));

        AuthenticationResponse response = userService.handleLoginRequest(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
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
