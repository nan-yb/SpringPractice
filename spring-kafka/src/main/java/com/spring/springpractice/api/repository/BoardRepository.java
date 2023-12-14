package com.spring.springpractice.api.repository;

import com.spring.springpractice.api.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom{



}
