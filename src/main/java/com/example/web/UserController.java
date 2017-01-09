package com.example.web;

import com.example.domain.User;
import com.example.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by djklaf on 2017/1/9.
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/user")
    public User findUser(String name){
        User user = userRepository.findUser(name);
        return user;
    }

    @RequestMapping(value = "/user2")
    public User findByName(String name){
        User user = userRepository.findByName(name);
        return user;
    }
}
