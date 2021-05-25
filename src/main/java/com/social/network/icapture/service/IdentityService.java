package com.social.network.icapture.service;

import com.social.network.icapture.exception.UserAlreadyExistsException;
import com.social.network.icapture.model.CustomUserDetails;
import com.social.network.icapture.model.User;
import com.social.network.icapture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class IdentityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User signUp(User user) {

        if (checkIfExists(user.getUsername())) {
            throw new UserAlreadyExistsException(user);
        }
        encodePassword(user);
        return userRepository.insertUser(user);
    }

    public boolean checkIfExists(String username) {
        User user = userRepository.findOneByUsername(username);
        return user != null;
    }

    public void encodePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // find user so can authenticate input with stored password
        User user = userRepository.findOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(
                    String.format("UsernameNotFoundException thrown: username + %s", user.getUsername()));
        }
        return new CustomUserDetails(user);
    }

}
