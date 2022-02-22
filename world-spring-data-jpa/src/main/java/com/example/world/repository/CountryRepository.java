package com.example.world.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.world.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String>{
	
	List<Country> findAllByContinent(String continent);
	
	@Query(nativeQuery = true, 
			value = "select distinct continent from country")
	List<String> getAllContinents();
}
