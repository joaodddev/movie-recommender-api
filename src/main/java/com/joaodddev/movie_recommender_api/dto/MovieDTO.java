package com.joaodddev.movie_recommender_api.dto;

public record MovieDTO(
        String title,
        String overview,
        Double vote_average) {
}
