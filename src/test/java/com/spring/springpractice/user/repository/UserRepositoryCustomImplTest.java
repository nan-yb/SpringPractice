package com.spring.springpractice.user.repository;

import com.spring.springpractice.user.domain.User;
import com.spring.springpractice.user.repository.user.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryCustomImplTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    private UserRepository userRepository;

    private User user;
    @Test
    void getUserList() {
        List<User> userList =  userRepository.getUserList("");
        Assert.assertNotNull(userList);
    }


}