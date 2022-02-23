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
	// TODO: define the dependencies

	public MovieRestController(/* TODO : inject required dependencies */) {
		// TODO: initialize the dependencies
	}

	// http://localhost:8100/imdb/api/v1/genres
	@GetMapping("/genres")
	@Cacheable("genres")
	public List<String> getGenres() {
		return genreRepository.findAll()
				.stream()
				.map(/* TODO: Write a function either by method reference or lambda expression */)
				./* make sure that genre names are sorted in alphabetical order */
				.toList();
	}

	// http://localhost:8100/imdb/api/v1/movies?genre=Drama&fromYear=1970&toYear=1979
	@GetMapping("/movies")
	public List<Movie> getMoviesByYearRangeAndGenre(@RequestParam String genre,@RequestParam  int fromYear,@RequestParam  int toYear) {
		return movieRepository.findBy/* TODO: design the repository method name */(genre,fromYear,toYear);
	}
}
