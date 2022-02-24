package com.example.imdb.controller;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.imdb.entity.Genre;
import com.example.imdb.entity.Movie;
import com.example.imdb.repository.GenreRepository;
import com.example.imdb.repository.MovieRepository;

@RestController
@RequestMapping
@CrossOrigin
public class MovieRestController {
	private MovieRepository movieRepository;
	private GenreRepository genreRepository;

	public MovieRestController(MovieRepository movieRepository, GenreRepository genreRepository) {
		this.movieRepository = movieRepository;
		this.genreRepository = genreRepository;
	}

	@GetMapping("/genres")
	@Cacheable("genres")
	public List<String> getGenres() {
		return genreRepository.findAll()
				.stream()
				.map(Genre::getDescription)
				.sorted()
				.toList();
	}

	@GetMapping("/movies")
	public List<Movie> getMoviesByYearRangeAndGenre(@RequestParam String genre,@RequestParam  int fromYear,@RequestParam  int toYear) {
		return movieRepository.findByGenresDescriptionAndYearBetween(genre,fromYear,toYear);
	}
}
