package project.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.cinema.model.Watched_movie;
import project.cinema.repository.Watched_movieRepository;

@Service
public class Watched_movieService {

	@Autowired
	private Watched_movieRepository watched_movieRepository;
	
	public Watched_movie findOne(long id) {
		Watched_movie watched_movie=this.watched_movieRepository.getOne(id);
		return watched_movie;
	}
	
	public List<Watched_movie> findAll(){
		List<Watched_movie> watched_movies=this.watched_movieRepository.findAll();
		return watched_movies;
	}
	
	public Watched_movie save(Watched_movie watched_movie) {
		return this.watched_movieRepository.save(watched_movie);
	}
}
