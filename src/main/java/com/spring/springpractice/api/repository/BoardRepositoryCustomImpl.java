package com.spring.springpractice.user.repository;


import com.spring.springpractice.user.domain.Board;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class BoardRepositoryCustomImpl extends QuerydslRepositorySupport implements BoardRepositoryCustom {
    public BoardRepositoryCustomImpl() {
        super(Board.class);
    }


}
