package com.personal.movieplanet.dto;


import com.personal.movieplanet.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class MovieDto {

	private long id;

	private String title;

	private Genre genre;

	private List<ReviewDto> reviews;

}