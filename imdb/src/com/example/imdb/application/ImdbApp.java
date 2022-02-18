package com.example.imdb.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.imdb.service.MovieService;

public class ImdbApp {

	public static void main(String[] args) {
		try(
			  var container = new AnnotationConfigApplicationContext(
		           // "com.example.imdb" 
			  )
		){
			container.scan("com.example.imdb");
			container.refresh();
			var movieService = container.getBean(MovieService.class);
			movieService.findAllMoviesByYearRange(1970, 1979)
			            .forEach(System.out::println);			
		} 
	}

}
