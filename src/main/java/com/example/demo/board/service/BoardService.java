package com.example.demo.board.service;

import com.example.demo.board.domain.BoardPost;
import com.example.demo.board.dto.BoardCreateRequest;
import com.example.demo.board.dto.BoardCreateResponse;
import com.example.demo.board.dto.BoardResponse;
import com.example.demo.board.repository.BoardPostRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional(readOnly = true)
public class BoardService {

    private final BoardPostRepository boardPostRepository;

    public BoardService(BoardPostRepository boardPostRepository) {
        this.boardPostRepository = boardPostRepository;
    }

    public List<BoardResponse> getBoardList() {
        return boardPostRepository.findAllByOrderByIdxDesc()
                .stream()
                .map(BoardResponse::from)
                .toList();
    }

    public BoardResponse getBoard(Long idx) {
        BoardPost boardPost = boardPostRepository.findById(idx)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "\uAC8C\uC2DC\uAE00\uC744 \uCC3E\uC744 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4."
                ));

        return BoardResponse.from(boardPost);
    }

    @Transactional
    public BoardCreateResponse createBoard(BoardCreateRequest request) {
        BoardPost boardPost = new BoardPost(request.getTitle().trim(), request.getContent().trim());
        BoardPost savedBoardPost = boardPostRepository.save(boardPost);

        return new BoardCreateResponse(
                "success",
                "\uAC8C\uC2DC\uAE00\uC774 \uC131\uACF5\uC801\uC73C\uB85C \uB4F1\uB85D\uB418\uC5C8\uC2B5\uB2C8\uB2E4.",
                savedBoardPost.getIdx()
        );
    }
}
