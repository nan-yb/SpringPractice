package com.spring.springpractice.user.controller;

import com.spring.springpractice.user.domain.User;
import com.spring.springpractice.user.repository.UserRepository;
import com.spring.springpractice.user.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    private final UserRepository userRepository;

    public UserController(IUserService userService , UserRepository userRepository ) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUserList(@PathVariable Long userId){
        return this.userRepository.getUserList("123");
    }
//
//
//    @GetMapping("/{userId}")
//    public List<UserDTO> getUserList(){
//        return this.userRepository.findById(userId).map(this.userE);
//    }

}
