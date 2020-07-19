package project.cinema.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.cinema.model.Cinema;
import project.cinema.model.Projection;
import project.cinema.model.Room;
import project.cinema.model.User;
import project.cinema.repository.CinemaRepository;
@Transactional
@Service
public class CinemaService {

	@Autowired
	private CinemaRepository cinemaRepository;
	
	@Autowired
	private UserService userService;
	

	public Cinema findOne(Long id) {
		Cinema cinema = this.cinemaRepository.findById(id).get();
		return cinema;
	}

	public List<Cinema> findAll() {
		List<Cinema> cinemas = this.cinemaRepository.findAll();
		return cinemas;
	}

	public Cinema save(Cinema cinema) {
		if (cinema.getName().trim().length() <= 3 || cinema.getAddress().trim().length() <= 3
				|| cinema.getEmail().trim().length() <= 3 || cinema.getPhone_number().trim().length() <= 3) {
			return null;
		}
		return this.cinemaRepository.save(cinema);
	}

	public boolean deleteById(Long id) {
		try {
			Cinema cinema=cinemaRepository.findById(id).get();
			List<User> users=this.userService.findAll();
			for(int i=0;i<users.size();i++) {
				for(Projection proj: users.get(i).getReserved_tickets()) {
					if(proj.getCinema().getId()==cinema.getId()) {
						users.get(i).getReserved_tickets().remove(proj);	
					}
				}
			}
			for(Room room : cinema.getRooms()){
				  	room.getProjections().clear();
			}
			cinema.getSchedule().clear();
			cinema.getRooms().clear();
			cinemaRepository.delete(cinema);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void editCinema(Cinema cinema) {
		this.cinemaRepository.updateCinema(cinema.getId(),cinema.getName(),cinema.getAddress(),cinema.getPhone_number(),cinema.getEmail());
	}
}
