package com.example.memo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemoUpdateResponse {
    private Long id;
    private String text;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public MemoUpdateResponse(Long id, String text, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.text = text;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

}
