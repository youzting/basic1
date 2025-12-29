package com.example.movie.dto;

import lombok.Getter;

@Getter
public class CreateMovieResponse {

    private final String title;

    public CreateMovieResponse(String title) {
        this.title = title;
    }
}
