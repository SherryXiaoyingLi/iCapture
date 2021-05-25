package com.social.network.icapture.controller;


import com.social.network.icapture.model.CustomUserDetails;
import com.social.network.icapture.model.User;
import com.social.network.icapture.security.JwtTokenService;
import com.social.network.icapture.service.IdentityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UserIdentityController {

    private final Logger logger = LoggerFactory.getLogger("AppsDeveloperBlog");

    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private IdentityService identityService;
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@Valid @RequestBody User user) {
        logger.info(String.format("Getting new user: %s", user.toString()));
        String jwt = jwtTokenService.generateToken(
                new CustomUserDetails(identityService.signUp(user)));
        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }


    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(), user.getPassword()));

        String jwt = jwtTokenService.generateToken(
                identityService.loadUserByUsername(user.getUsername()));
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
