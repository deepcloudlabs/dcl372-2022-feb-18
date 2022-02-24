package com.example.imdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.imdb.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	List<Movie> findByGenresDescriptionAndYearBetween(String genre, int fromYear, int toYear);

}
