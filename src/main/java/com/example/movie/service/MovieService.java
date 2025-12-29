package com.example.movie.service;


import com.example.movie.dto.*;
import com.example.movie.entity.Movie;
import com.example.movie.repository.MovieRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    @Transactional
    public CreateMovieResponse save(CreateMovieRequest request) {
        Movie movie = new Movie(
                request.getTitle()
        );
        Movie savedMovie = movieRepository.save(movie);
        return new CreateMovieResponse(
                savedMovie.getTitle()
        );
    }

    @Transactional(readOnly = true)
    public List<GetMovieResponse> getALL() {
        List<Movie> moives = movieRepository.findAll();
        List<GetMovieResponse> dtos = new ArrayList<>();

        for (Movie movie : moives) {
            GetMovieResponse dto = new GetMovieResponse(
                    movie.getId(),
                    movie.getTitle()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public GetMovieResponse getOne(Long movieId){
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 영화")
        );
        return new GetMovieResponse(
                movie.getId(),
                movie.getTitle()
        );
    }

    @Transactional
    public UpdateMovieResponse update(Long movieId, UpdateMovieRequest request){
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 영화")
        );
        movie.update(request.getTitle());
        return new UpdateMovieResponse(movie.getId(), movie.getTitle());
    }
    public void delete(Long movieId){
        boolean existence = movieRepository.existsById(movieId);
        if (!existence) {
            throw new IllegalStateException("존재하지 않는 영화");
        }

        movieRepository.deleteById(movieId);
    }
}
