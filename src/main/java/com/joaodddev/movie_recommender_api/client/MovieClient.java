package com.joaodddev.movie_recommender_api.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.joaodddev.movie_recommender_api.config.TMDBConfig;
import com.joaodddev.movie_recommender_api.dto.TMDBResponseDTO;

@Service
public class MovieClient {

    private final WebClient webClient;
    private final TMDBConfig config;

    public MovieClient(WebClient.Builder builder, TMDBConfig config) {
        this.webClient = builder.baseUrl(config.getBaseUrl()).build();
        this.config = config;
    }

    public TMDBResponseDTO searchMovie(String name) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/movie")
                        .queryParam("api_key", config.getApiKey())
                        .queryParam("query", name)
                        .build())
                .retrieve()
                .bodyToMono(TMDBResponseDTO.class)
                .block();
    }

    public TMDBResponseDTO getRecommendations(int movieId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/movie/{movie_id}/recommendations")
                        .queryParam("api_key", config.getApiKey())
                        .build(movieId))
                .retrieve()
                .bodyToMono(TMDBResponseDTO.class)
                .block();
    }
}
