package com.personal.movieplanet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ReviewDto {

    private String movieReview;

    private double rating;

    private Long movieId;
}
