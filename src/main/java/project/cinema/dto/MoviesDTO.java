package project.cinema.dto;

import java.util.List;

import project.cinema.model.Movie;

public class MoviesDTO {
	
	private List<Movie> movies;
	
	private List<String> genres;

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	public MoviesDTO(){}

	public MoviesDTO(List<Movie> movies, List<String> genres) {
		super();
		this.movies = movies;
		this.genres = genres;
	}
	
	

}
