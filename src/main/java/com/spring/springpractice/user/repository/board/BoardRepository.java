package com.spring.springpractice.user.repository.board;

import com.spring.springpractice.user.domain.Board;
import com.spring.springpractice.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom{



}
