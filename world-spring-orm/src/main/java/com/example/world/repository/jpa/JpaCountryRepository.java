package com.example.world.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.example.world.entity.Country;
import com.example.world.repository.CountryRepository;

@Repository
public class JpaCountryRepository implements CountryRepository {
	private EntityManager entityManager;
	
	public JpaCountryRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Country> findCountriesByContinent(String continent) {
		return 
		entityManager.createNamedQuery("Country.findByContinent",
				Country.class)
				.setParameter("continent", continent)
				.getResultList();
	}

	@Override
	public List<String> getAllContinents() {
		return entityManager.createNativeQuery(
				"select distinct continent from country")
				        .getResultList();
	}

}
