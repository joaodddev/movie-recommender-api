package com.joaodddev.movie_recommender_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joaodddev.movie_recommender_api.dto.MovieDTO;
import com.joaodddev.movie_recommender_api.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public List<MovieDTO> search(@RequestParam String name) {
        return service.buscarFilmes(name);
    }

    @GetMapping("/recommend")
    public List<MovieDTO> recommend(@RequestParam int movieId) {
        return service.recomendarFilmes(movieId);
    }
}
