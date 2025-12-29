package com.example.movie.dto;

import lombok.Getter;

@Getter
public class GetMovieResponse {
    private Long id;
    private String title;

    public GetMovieResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
