package com.example.movie.dto;

import lombok.Getter;

@Getter
public class UpdateMovieResponse {

    private final Long id;
    private final String title;

    public UpdateMovieResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
