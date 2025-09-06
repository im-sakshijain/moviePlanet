package com.personal.movieplanet.controller;

import com.personal.movieplanet.dto.MovieDto;
import com.personal.movieplanet.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@PostMapping("/add")
	public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieRequest) {

		//return ResponseEntity.ok(movieService.addMovie(movieRequest));
		return new ResponseEntity<>(movieService.addMovie(movieRequest), HttpStatus.CREATED); // 201 CREATED;
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovieDto> getMovieById(@PathVariable(name = "id") long id) {

		return ResponseEntity.ok(movieService.getMovie(id));
	}

	@GetMapping("/title")
	public ResponseEntity<MovieDto> getMovieByTitle(@RequestParam String title) {

		return ResponseEntity.ok(movieService.getMovie(title));
	}
}