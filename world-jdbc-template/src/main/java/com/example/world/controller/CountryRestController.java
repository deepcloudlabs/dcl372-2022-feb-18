package com.example.world.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.world.entity.Country;
import com.example.world.repository.CountryRepository;

@RestController
@RequestScope
@CrossOrigin
public class CountryRestController {
	private CountryRepository countryRepository;
	
	public CountryRestController(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
    // http://localhost:8100/world/api/v1/continents
	@GetMapping("continents")
	public List<String> getAllContinents(){
		return countryRepository.getAllContinents();
	}
	// http://localhost:8100/world/api/v1/countries?continent=Asia
	@GetMapping("countries")
	public List<Country> getCountriesByContinent(
			@RequestParam String continent){
		return countryRepository.findCountriesByContinent(continent);
	}
}
