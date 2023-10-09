package com.spring.springpractice.user.repository.user;

import com.spring.springpractice.user.domain.user.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> getUserList(String name);

}
