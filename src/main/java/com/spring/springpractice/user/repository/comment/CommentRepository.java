package com.spring.springpractice.user.repository.comment;

import com.spring.springpractice.user.domain.Comment;
import com.spring.springpractice.user.domain.QComment;
import com.spring.springpractice.user.domain.User;
import com.spring.springpractice.user.repository.board.BoardRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;

public interface CommentRepository extends
        JpaRepository<Comment, Long> ,
        CommentRepositoryCustom
//        QuerydslPredicateExecutor<Comment>,
//        QuerydslBinderCustomizer<QComment>
{

}
