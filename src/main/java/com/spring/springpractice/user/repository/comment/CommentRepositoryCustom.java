package com.spring.springpractice.user.repository.comment;

import com.spring.springpractice.user.domain.Board;
import com.spring.springpractice.user.domain.Comment;
import com.spring.springpractice.user.domain.User;

import java.util.List;

public interface CommentRepositoryCustom {

    List<Comment> getCommentList(Long boardId);

    void deleteAllComment(Long boardId);

    void deleteCommentByCommentId(Long commentId);
}
