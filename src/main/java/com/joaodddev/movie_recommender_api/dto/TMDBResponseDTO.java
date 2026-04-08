package com.joaodddev.movie_recommender_api.dto;

import java.util.List;

public record TMDBResponseDTO(
        List<MovieDTO> results) {
}
