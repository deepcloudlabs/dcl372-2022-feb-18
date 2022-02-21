package com.example.world.repository.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.world.entity.Country;
import com.example.world.repository.CountryRepository;

@Repository
public class JdbcTemplateCountryRepository implements CountryRepository {
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public JdbcTemplateCountryRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Country> findCountriesByContinent(String continent) {
		return jdbcTemplate.queryForStream(
		   CountryRepository.SELECT_COUNTRIES_BY_CONTINENT, 
		   Map.of("continent", continent),
		   CountryRepository::resultSetToCountryMapper
		).toList();
	}

	@Override
	public List<String> getAllContinents() {
		return jdbcTemplate.queryForList(
				CountryRepository.SELECT_DISTINCT_CONTINENTS, 
				Map.of(),
				String.class);
	}

}
