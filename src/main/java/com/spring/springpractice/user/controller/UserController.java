package com.spring.springpractice.user.controller;

import com.spring.springpractice.user.domain.User;
import com.spring.springpractice.user.repository.UserRepository;
import com.spring.springpractice.user.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    private final UserRepository userRepository;

    public UserController(IUserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/list")
    public List<User> getUserList() {
        return this.userRepository.getUserList("123");
    }

}
