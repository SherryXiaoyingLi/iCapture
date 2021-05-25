package com.social.network.icapture.service;

import com.social.network.icapture.model.User;
import com.social.network.icapture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(long userId) {
        return userRepository.findOneById(userId);
    }


}
