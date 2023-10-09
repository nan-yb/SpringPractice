package com.spring.springpractice.user.repository.user;

import com.spring.springpractice.user.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

    List<User> getUserList(String name);

}
