package com.spring.springpractice.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.springpractice.user.domain.QUser;
import com.spring.springpractice.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;


public class UserRepositoryCustomImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {

    @Autowired
    private JPAQueryFactory queryFactory;

    public UserRepositoryCustomImpl() {
        super(User.class);
    }

    @Override
    public List<User> getUserList(String name) {
        QUser user = QUser.user;

        return queryFactory.selectFrom(user).fetch();
    }
}
