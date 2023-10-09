package com.spring.springpractice.user.repository.board;

import com.spring.springpractice.user.domain.board.Board;
import com.spring.springpractice.user.domain.user.User;
import com.spring.springpractice.user.repository.user.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<User, Long>, BoardRepositoryCustom{



}
