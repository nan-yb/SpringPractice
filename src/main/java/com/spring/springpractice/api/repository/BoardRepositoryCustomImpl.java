package com.spring.springpractice.api.repository;


import com.spring.springpractice.api.domain.Board;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class BoardRepositoryCustomImpl extends QuerydslRepositorySupport implements BoardRepositoryCustom {
    public BoardRepositoryCustomImpl() {
        super(Board.class);
    }


}
