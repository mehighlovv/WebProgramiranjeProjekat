package project.cinema.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.cinema.dto.ManagerDTO;
import project.cinema.dto.RoomDTO;
import project.cinema.dto.UserDTO;
import project.cinema.model.Cinema;
import project.cinema.model.Projection;
import project.cinema.model.Roles;
import project.cinema.model.Room;
import project.cinema.model.User;
import project.cinema.repository.UserRepository;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MovieService movieService;

	@Autowired
	private Watched_movieService watched_movieService;
	@Autowired
	private ProjectionService projectionService;
	@Autowired
	private CinemaService cinemaService;
	
	@Autowired
	private RoomService roomService;

	public User findOne(Long id) {
		User user = this.userRepository.findById(id).get();
		return user;
	}

	public List<User> findAll() {
		List<User> users = this.userRepository.findAll();
		return users;
	}

	public User save(User user) {
		return this.userRepository.save(user);
	}

	public boolean login(UserDTO userDTO, User user) {
		if (user.getPassword().equals(userDTO.getPassword())) {
			return true;
		}
		return false;
	}

	public User checkEmail(UserDTO userDTO) {
		User user = this.userRepository.findByEmail(userDTO.getEmail());
		if (user == null)
			return null;
		return user;
	}

	public void RateIt(Long rating, Long movie_id, Long watched_movie_id) {
		this.watched_movieService.setRating(watched_movie_id, rating);
		double avg = this.watched_movieService.calculateRating(movie_id);
		this.movieService.setRating(movie_id, avg);
		return;
	}

	public void cancelReservation(Long user_id, Long projection_id) {
		User user = this.userRepository.findById(user_id).get();
		Projection projection = this.projectionService.findOne(projection_id);
		user.getReserved_tickets().remove(projection);
		return;
	}

	public List<User> getManagers() {
		return this.userRepository.findByRole(Roles.MANAGER);
	}

	public void deleteUser(Long id) {
		this.userRepository.deleteById(id);

	}

	public void saveManager(ManagerDTO managerDTO) {
		Cinema cinema = cinemaService.findOne(managerDTO.getCinema_id());
		User user = new User(managerDTO.getUsername(), managerDTO.getPassword(), managerDTO.getName(),
				managerDTO.getLastname(), managerDTO.getPhone_number(), managerDTO.getEmail(), managerDTO.getDate(),
				managerDTO.getRole(), managerDTO.isActivity(), cinema, null, null);
		this.userRepository.save(user);
	}
	public boolean addReservation(Long user_id, Long projection_id) {
		User user = this.userRepository.findById(user_id).get();
		Projection projection = this.projectionService.findOne(projection_id);
		if(user.getReserved_tickets().contains(projection)) {
			return false;
		}
		
		for(Room room: projection.getRooms()) {
			if(room.getCapacity()-projection.getUsers().size()>0) {
				user.getReserved_tickets().add(projection);
				return true;
			}
				
		}
		return false;
	}
	
	public void addRoom(RoomDTO roomDTO) {
		Cinema cinema=this.cinemaService.findOne(roomDTO.getCinema_id());
		Room room=new Room(roomDTO.getCapacity(),roomDTO.getMark(),null,cinema);
		this.roomService.save(room);
	}
	public void editRoom(Room room) {
		this.roomService.editRoom(room);
	}
}