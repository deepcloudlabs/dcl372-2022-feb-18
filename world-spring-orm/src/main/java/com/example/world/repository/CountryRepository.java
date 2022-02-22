package com.example.world.repository;

import java.util.List;

import com.example.world.entity.Country;

public interface CountryRepository {
	List<Country> findCountriesByContinent(String continent);

	List<String> getAllContinents();
}
