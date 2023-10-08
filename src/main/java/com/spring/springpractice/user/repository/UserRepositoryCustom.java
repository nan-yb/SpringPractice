package com.spring.springpractice.user.repository;

import com.spring.springpractice.user.domain.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> getUserList(String name);





}
