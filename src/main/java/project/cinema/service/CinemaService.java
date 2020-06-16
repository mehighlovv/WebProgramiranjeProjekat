package project.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.cinema.model.Cinema;
import project.cinema.repository.CinemaRepository;

@Service
public class CinemaService {

	@Autowired
	private CinemaRepository cinemaRepository;
	
	public Cinema findOne(long id) {
		Cinema cinema=this.cinemaRepository.getOne(id);
		return cinema;
	}
	
	public List<Cinema> findAll(){
		List<Cinema> cinemas=this.cinemaRepository.findAll();
		return cinemas;
	}
	
	public Cinema save(Cinema cinema) {
		if (cinema.getName().trim().length() <= 3 || cinema.getAddress().trim().length() <= 3 || cinema.getEmail().trim().length() <= 3 || cinema.getPhone_number().trim().length() <= 3) {
			return null;
		}
		return this.cinemaRepository.save(cinema);
	}
}
