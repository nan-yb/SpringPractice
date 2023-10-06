package com.spring.springpractice.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RequestPredicate;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.accept;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration(proxyBeanMethods = false)
public class MyRoutingConfiguration {
        private static final RequestPredicate ACCEPT_JSON = accept(MediaType.APPLICATION_JSON);

        @Bean
        public RouterFunction<ServerResponse> routerFunction(MyUserHandler userHandler) {
            return route()
                    .GET("/{user}", ACCEPT_JSON, userHandler::getUser)
                    .build();
        }

    }
