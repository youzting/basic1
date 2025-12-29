package com.example.movie.controller;

import com.example.movie.dto.*;
import com.example.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public  class MovieController {

    private final MovieService movieService;

    @PostMapping("/movies")
    public ResponseEntity<CreateMovieResponse> create(@RequestBody CreateMovieRequest request) {
        CreateMovieResponse result = movieService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<GetMovieResponse>> getAll() {
        List<GetMovieResponse> result = movieService.getALL();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<GetMovieResponse> getOne(@PathVariable("movieId") Long movieId) {
        GetMovieResponse result = movieService.getOne(movieId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/movies/{movieId}")
    public ResponseEntity<UpdateMovieResponse> update(@PathVariable("movieId") Long movieId, @RequestBody UpdateMovieRequest request) {
        UpdateMovieResponse result = movieService.update(movieId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/movies/{movieId}")
    public ResponseEntity<Void> delete(@PathVariable("movieId") Long movieId) {
        movieService.delete(movieId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

