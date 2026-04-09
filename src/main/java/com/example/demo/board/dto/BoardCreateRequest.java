package com.example.demo.board.dto;

import jakarta.validation.constraints.NotBlank;

public class BoardCreateRequest {

    @NotBlank(message = "\uC81C\uBAA9\uC744 \uC785\uB825\uD574 \uC8FC\uC138\uC694.")
    private String title;

    @NotBlank(message = "\uB0B4\uC6A9\uC744 \uC785\uB825\uD574 \uC8FC\uC138\uC694.")
    private String content;

    public BoardCreateRequest() {
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
