package com.example.memo.dto;

import java.time.LocalDateTime;

public class MemoGetResponse {
    private Long id;
    private String text;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public MemoGetResponse(Long id, String text, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.text = text;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
