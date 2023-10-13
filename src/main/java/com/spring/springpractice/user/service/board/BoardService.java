package com.spring.springpractice.user.service.board;

import com.spring.springpractice.user.domain.Board;
import com.spring.springpractice.user.domain.Comment;
import com.spring.springpractice.user.domain.QComment;
import com.spring.springpractice.user.domain.User;
import com.spring.springpractice.user.dto.BoardDto;
import com.spring.springpractice.user.dto.CommentDto;
import com.spring.springpractice.user.dto.UserDto;
import com.spring.springpractice.user.repository.board.BoardRepository;
import com.spring.springpractice.user.repository.board.BoardRepositoryCustom;
import com.spring.springpractice.user.repository.comment.CommentRepository;
import com.spring.springpractice.user.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    private List<Board> getBoardList(User user) {
        return boardRepository.getBoardList(user);
    }

    public BoardDto saveBoard(BoardDto dto) {
        return BoardDto.from(
                boardRepository.save(Board.of(dto.usrId() , dto.boardTitle(), dto.boardContent()))
        );
    }

    public CommentDto saveComment(CommentDto dto) {
        return CommentDto.from(
                commentRepository.save(Comment.of(dto.boardId() , dto.usrId() , dto.commentContent()))
        );
    }

    public void deleteAllComment(Long boardId) {
        commentRepository.deleteAllComment(boardId);
    }

    public void deleteCommentByCommentId(Long commentId) {
        commentRepository.deleteCommentByCommentId(commentId);
    }

}
