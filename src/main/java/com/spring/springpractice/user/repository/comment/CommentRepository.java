package com.spring.springpractice.user.repository.comment;

import com.spring.springpractice.user.domain.Comment;
import com.spring.springpractice.user.domain.User;
import com.spring.springpractice.user.repository.board.BoardRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> , CommentRepositoryCustom{

}
