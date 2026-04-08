package com.joaodddev.movie_recommender_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joaodddev.movie_recommender_api.client.MovieClient;
import com.joaodddev.movie_recommender_api.dto.MovieDTO;

@Service
public class MovieService {

    private final MovieClient client;

    public MovieService(MovieClient client) {
        this.client = client;
    }

    public List<MovieDTO> buscarFilmes(String nome) {
        return client.searchMovie(nome).results();
    }

    public List<MovieDTO> recomendarFilmes(int movieId) {
        return client.getRecommendations(movieId).results();
    }
}
