package com.spring.springpractice.conf;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class MyUserHandler {
    public ServerResponse getUser(ServerRequest request) {
        return ServerResponse.ok().build();
    }
}
