package com.example.world.repository;

import java.util.List;

import com.example.world.entity.Country;

public interface CountryRepository {
	String SELECT_DISTINCT_CONTINENTS = """
		select distinct continent from country		
			""";
	String SELECT_COUNTRIES_BY_CONTINENT = """
			select code, name, continent, population
			from country
			where continent = ?
			""";
	String COLUMN_CODE = "CODE";
	String COLUMN_NAME = "NAME";
	String COLUMN_POPULATION = "POPULATION";
	List<Country> findCountriesByContinent(String continent);
	List<String> getAllContinents();
}
