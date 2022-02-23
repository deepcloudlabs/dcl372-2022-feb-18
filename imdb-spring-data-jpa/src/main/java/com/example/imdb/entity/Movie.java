package com.example.imdb.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {
	@Id
	@Column(name="movieid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private String title;
	private String imdb;
	private int year;

	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="moviedirectors",
		joinColumns={
			@JoinColumn(name="movieid",referencedColumnName="movieid",nullable=false)	
		},
		inverseJoinColumns={
				@JoinColumn(name="directorid",referencedColumnName="directorid",nullable=false)	
		}
	)
	private List<Director> directors;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="moviegenres",
		joinColumns={
				@JoinColumn(name="movieid",referencedColumnName="movieid",nullable=false)	
		},
		inverseJoinColumns={
				@JoinColumn(name="genreid",referencedColumnName="genreid",nullable=false)	
		}
	)
	private List<Genre> genres;

	public Movie() {
	}

	@PrePersist
	public void initCreatedTime() {
		
	}
	
	@PreUpdate
	public void initModifiedTime() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", imdb=" + imdb + ", year=" + year + ", genres=" + genres
				+ "]";
	}

}
