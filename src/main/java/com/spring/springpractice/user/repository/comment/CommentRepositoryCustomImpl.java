package com.spring.springpractice.user.repository.comment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.springpractice.user.domain.Comment;
import static com.spring.springpractice.user.domain.QComment.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CommentRepositoryCustomImpl extends QuerydslRepositorySupport implements CommentRepositoryCustom {

    @Autowired
    private JPAQueryFactory queryFactory;

    public CommentRepositoryCustomImpl() {
        super(Comment.class);
    }

    @Override
    public List<Comment> getCommentList(Long boardId) {
        return queryFactory.selectFrom(comment).where(comment.boardId.eq(boardId)).fetch();
    }


    @Override
    public void deleteAllComment(Long boardId) {
        queryFactory.delete(comment).where(comment.boardId.eq(boardId));

    }

    @Override
    public void deleteCommentByCommentId(Long commentId) {
        queryFactory.delete(comment).where(comment.commentId.eq(commentId));

    }
}
