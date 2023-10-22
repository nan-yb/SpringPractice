package com.spring.springpractice.user.repository;

import com.spring.springpractice.user.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom{



}
