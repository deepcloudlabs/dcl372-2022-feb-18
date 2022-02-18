package com.example.imdb.dto;
import java.util.Collection;
import java.util.Collections;

import com.example.imdb.domain.Movie;
/**
 * 
 * @author Binnur Kurt
 *
 */
public class CriteriaBean {
	private boolean yearRangeSelected;
	private Integer fromYear;
	private Integer toYear;
	private boolean genreSelected;
	private Integer genre;
	private boolean directorSelected;
	private Integer director;
    private Collection<Movie> movies = Collections.emptyList();
	
	public CriteriaBean() {
	}

    public Collection<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Collection<Movie> movies) {
        this.movies = movies;
    }	
	
	public boolean isYearRangeSelected() {
		return yearRangeSelected;
	}

	public void setYearRangeSelected(boolean yearRangeSelected) {
		this.yearRangeSelected = yearRangeSelected;
	}

	public Integer getFromYear() {
		return fromYear;
	}

	public void setFromYear(Integer fromYear) {
		this.fromYear = fromYear;
	}

	public Integer getToYear() {
		return toYear;
	}

	public void setToYear(Integer toYear) {
		this.toYear = toYear;
	}

	public boolean isGenreSelected() {
		return genreSelected;
	}

	public void setGenreSelected(boolean genreSelected) {
		this.genreSelected = genreSelected;
	}

	public Integer getGenre() {
		return genre;
	}

	public void setGenre(Integer genre) {
		this.genre = genre;
	}

	public boolean isDirectorSelected() {
		return directorSelected;
	}

	public void setDirectorSelected(boolean directorSelected) {
		this.directorSelected = directorSelected;
	}

	public Integer getDirector() {
		return director;
	}

	public void setDirector(Integer director) {
		this.director = director;
	}


    @Override
    public String toString() {
        return "CriteriaBean{" +
                "yearRangeSelected=" + yearRangeSelected +
                ", fromYear=" + fromYear +
                ", toYear=" + toYear +
                ", genreSelected=" + genreSelected +
                ", genre=" + genre +
                ", directorSelected=" + directorSelected +
                ", director=" + director +
                '}';
    }

}
