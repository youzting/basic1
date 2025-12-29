package com.example.member.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class MemberGetResponse {
    private final Long id;
    private final String name;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public MemberGetResponse(Long id, String name, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
