package com.spring.springpractice.user.controller;

import com.spring.springpractice.conf.response.Message;
import com.spring.springpractice.conf.response.Status;
import com.spring.springpractice.user.domain.user.User;
import com.spring.springpractice.user.dto.UserDto;
import com.spring.springpractice.user.repository.user.UserRepository;
import com.spring.springpractice.user.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/list")
    public List<User> getUserList() {
        return this.userRepository.getUserList("123");
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto user) {
        Message msg = new Message();

        UserDto dto =userService.saveUser(user);
        msg.setStatus(Status.OK);
        msg.setData(dto);

        return new ResponseEntity<Message>(msg, null, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUserByUser(@RequestBody User user) {
        Message msg = new Message();
        msg.setStatus(Status.OK);

        userService.deleteUser(user);

        return new ResponseEntity<Message>(msg, null, HttpStatus.OK);
    }
}
