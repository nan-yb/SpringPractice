package com.spring.springpractice.user.repository.comment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.springpractice.user.domain.Comment;
import com.spring.springpractice.user.domain.QComment;
import com.spring.springpractice.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CommentRepositoryCustomImpl extends QuerydslRepositorySupport implements CommentRepositoryCustom{

    @Autowired
    private JPAQueryFactory queryFactory;

    public CommentRepositoryCustomImpl() {
        super(Comment.class);
    }

    @Override
    public List<Comment> getCommentList(Long boardId) {
        QComment qcomment = QComment.comment;

        return queryFactory.selectFrom(qcomment).where(qcomment.boardId.eq(boardId)).fetch();
    }


    @Override
    public void deleteAllComment(Long boardId) {

        QComment qComment = QComment.comment;

        queryFactory.delete(qComment).where(qComment.boardId.eq(boardId));

    }

    @Override
    public void deleteCommentByCommentId(Long commentId) {
        QComment qComment = QComment.comment;

        queryFactory.delete(qComment).where(qComment.commentId.eq(commentId));

    }
}
