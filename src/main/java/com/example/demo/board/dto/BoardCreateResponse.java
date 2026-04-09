package com.example.demo.board.dto;

public record BoardCreateResponse(
        String status,
        String message,
        Long idx
) {
}
