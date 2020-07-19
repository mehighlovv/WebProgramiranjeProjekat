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
	
	public Watched_movie findOne(Long id) {
		Watched_movie watched_movie=this.watched_movieRepository.findById(id).get();
		return watched_movie;
	}
	
	public List<Watched_movie> findAll(){
		List<Watched_movie> watched_movies=this.watched_movieRepository.findAll();
		return watched_movies;
	}
	
	public Watched_movie save(Watched_movie watched_movie) {
		return this.watched_movieRepository.save(watched_movie);
	}
	
	public List<Watched_movie> getRatedMovies(Long id){
		return this.watched_movieRepository.findByMovieId(id);
	}
	public void setRating(Long id,long rating) {
		this.watched_movieRepository.setRating(id, rating);
	}
	
	public double calculateRating(Long id) {
		List<Watched_movie> rated=this.watched_movieRepository.findByMovieId(id);
		double avg=0;
		int counter=0;
		for(int i=0;i<rated.size();i++) {
			if(rated.get(i).getRating()==0) {
				continue;
			}
			else {
				avg+=rated.get(i).getRating();
				counter++;
			}
		}
		avg/=counter;
		return avg;
	}
}
