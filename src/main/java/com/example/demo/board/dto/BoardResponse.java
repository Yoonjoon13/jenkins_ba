package com.example.demo.board.dto;

import com.example.demo.board.domain.BoardPost;

public record BoardResponse(
        Long idx,
        String title,
        String content
) {
    public static BoardResponse from(BoardPost boardPost) {
        return new BoardResponse(
                boardPost.getIdx(),
                boardPost.getTitle(),
                boardPost.getContent()
        );
    }
}
