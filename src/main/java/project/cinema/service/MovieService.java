package project.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.cinema.model.Movie;
import project.cinema.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public Movie findOne(long id) {
		Movie movie=this.movieRepository.getOne(id);
		return movie;
	}
	
	public List<Movie> findAll(){
		List<Movie> movies=this.movieRepository.findAll();
		return movies;
	}
	
	public Movie save(Movie movie) {
		return this.movieRepository.save(movie);
	}
}
