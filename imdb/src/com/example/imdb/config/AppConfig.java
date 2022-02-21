package com.example.imdb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.imdb.service.MovieService;
import com.example.imdb.service.SequenceService;
import com.example.imdb.service.business.InMemoryMovieService;

@Configuration
@EnableAspectJAutoProxy
@EnableScheduling
public class AppConfig {

	@Bean("elma")
	//@Scope("prototype")
	@Lazy
	public MovieService createMovieService(SequenceService sequenceService) {
		System.err.println("AppConfig::createMovieService");
		System.err.println(sequenceService.getClass().getName());
		return new InMemoryMovieService(sequenceService);
	}
}
