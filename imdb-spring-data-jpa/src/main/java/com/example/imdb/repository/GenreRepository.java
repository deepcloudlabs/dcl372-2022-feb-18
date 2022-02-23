package com.example.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.imdb.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
