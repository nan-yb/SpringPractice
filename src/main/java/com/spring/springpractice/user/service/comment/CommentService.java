package com.spring.springpractice.user.service.comment;

import com.spring.springpractice.user.domain.Board;
import com.spring.springpractice.user.domain.Comment;
import com.spring.springpractice.user.domain.User;
import com.spring.springpractice.user.repository.board.BoardRepository;
import com.spring.springpractice.user.repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {


    private CommentRepository commentRepository;

    private List<Comment> getCommentService(Long boardId) {

        return null;
    }
}
