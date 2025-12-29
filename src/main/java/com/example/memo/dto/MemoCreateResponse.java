package com.example.memo.dto;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class MemoCreateResponse {
    private final Long id;
    private final String text;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public MemoCreateResponse(Long id, String text, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
