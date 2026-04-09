package com.example.demo.board.controller;

import com.example.demo.board.dto.BoardCreateRequest;
import com.example.demo.board.dto.BoardCreateResponse;
import com.example.demo.board.dto.BoardResponse;
import com.example.demo.board.service.BoardService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public List<BoardResponse> getBoardList() {
        return boardService.getBoardList();
    }

    @GetMapping("/{idx}")
    public BoardResponse getBoard(@PathVariable Long idx) {
        return boardService.getBoard(idx);
    }

    @PostMapping("/reg")
    @ResponseStatus(HttpStatus.CREATED)
    public BoardCreateResponse createBoard(@Valid @RequestBody BoardCreateRequest request) {
        return boardService.createBoard(request);
    }
}
