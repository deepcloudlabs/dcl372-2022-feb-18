package com.example.imdb.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.imdb.service.MovieService;

public class ImdbApp {

	public static void main(String[] args) {
		try(
			  var container = new AnnotationConfigApplicationContext(
		            "com.example.imdb" 
			  )
		){
//			container.scan("com.example.imdb");
//			container.refresh();
			var movieService = container.getBean(MovieService.class);
			movieService.findAllMoviesByYearRange(1970, 1979)
			            .forEach(System.out::println);
			System.err.println(movieService.getClass().getName());
			System.err.println(movieService.findAllGenres()); 
			System.err.println(movieService.findAllGenres()); 
			System.err.println(movieService.findAllGenres()); 
			System.err.println(movieService.findAllGenres()); 
			System.err.println(movieService.findAllGenres()); 
			System.err.println(movieService.findAllGenres()); 
			System.err.println(movieService.findAllGenres()); 
			System.err.println(movieService.findAllGenres()); 
			System.err.println(movieService.findAllGenres()); 
//			movieService = container.getBean(MovieService.class);
//			movieService = container.getBean(MovieService.class);
//			movieService = container.getBean(MovieService.class);
//			movieService = container.getBean(MovieService.class);
//			movieService = container.getBean(MovieService.class);
//			movieService = container.getBean(MovieService.class);

			//			container.getBeansOfType(Object.class)
//			         .forEach((name, component) -> {
//			        	 System.out.println(String.format("%24s: %16s", name,component.getClass().getName()));
//			         });
		}
		System.gc();
		
	}

}
