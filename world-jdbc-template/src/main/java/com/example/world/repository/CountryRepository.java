package com.example.world.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.world.entity.Country;

public interface CountryRepository {
	String SELECT_DISTINCT_CONTINENTS = """
			select distinct continent from country
				""";
	String SELECT_COUNTRIES_BY_CONTINENT = """
			select code, name, continent, population
			from country
			where continent = :continent
			""";
	String COLUMN_CODE = "CODE";
	String COLUMN_NAME = "NAME";
	String COLUMN_CONTINENT = "CONTINENT";
	String COLUMN_POPULATION = "POPULATION";

	List<Country> findCountriesByContinent(String continent);

	List<String> getAllContinents();

	public static Country resultSetToCountryMapper(ResultSet resultSet, int index) throws SQLException {
		return new Country(
			resultSet.getString(CountryRepository.COLUMN_CODE),
			resultSet.getString(CountryRepository.COLUMN_NAME),
			resultSet.getString(CountryRepository.COLUMN_CONTINENT),
			resultSet.getLong(CountryRepository.COLUMN_POPULATION)
		);
	}
}
