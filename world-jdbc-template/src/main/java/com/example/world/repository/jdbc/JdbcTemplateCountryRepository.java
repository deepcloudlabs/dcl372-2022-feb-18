package com.example.world.repository.jdbc;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.world.entity.Country;
import com.example.world.repository.CountryRepository;

@Repository
public class JdbcTemplateCountryRepository implements CountryRepository {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplateCountryRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Country> findCountriesByContinent(String continent) {
		return jdbcTemplate.queryForStream(
		   CountryRepository.SELECT_COUNTRIES_BY_CONTINENT, 
		   (rs,index) -> {
			  var country = new Country();
	  country.setCode(rs.getString(CountryRepository.COLUMN_CODE));
	  country.setName(rs.getString(CountryRepository.COLUMN_NAME));
	  country.setContinent(continent);
	  country.setPopulation(rs.getLong(CountryRepository.COLUMN_POPULATION));
			  return country;
		    },
		   continent).toList();
	}

	@Override
	public List<String> getAllContinents() {
		return jdbcTemplate.queryForList(
				CountryRepository.SELECT_DISTINCT_CONTINENTS, 
				String.class);
	}

}
