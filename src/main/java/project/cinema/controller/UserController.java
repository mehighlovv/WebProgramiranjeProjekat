package project.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import project.cinema.dto.ManagerDTO;
import project.cinema.dto.ProjectionDTO;
import project.cinema.dto.RatingDTO;
import project.cinema.dto.ReservationDTO;
import project.cinema.dto.RoomDTO;
import project.cinema.dto.UserDTO;
import project.cinema.model.Cinema;
import project.cinema.model.Movie;
import project.cinema.model.Room;
import project.cinema.model.User;
import project.cinema.service.CinemaService;
import project.cinema.service.MovieService;
import project.cinema.service.ProjectionService;
import project.cinema.service.RoomService;
import project.cinema.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;	
	@Autowired
	private CinemaService cinemaService;
	@Autowired
	private RoomService roomService;
	@Autowired 
	private MovieService movieService;
	@Autowired
	private ProjectionService projectionService;
	@GetMapping("/register")
	public String register(){
		return "register.html";
	}
	
	@PostMapping("/register-user")
	public ResponseEntity<?> register_user(@RequestBody User user) {
		User user1;
		try {
			user1=userService.save(user);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}
	
	@GetMapping("/account/{id}")
	public String account(@PathVariable(name = "id") Long id,Model model) {
		User user=this.userService.findOne(id);
		model.addAttribute("user", user);
		return "account.html";
	}
	@GetMapping("/account/{id}/watched_movies")
	public String watched_movies(@PathVariable(name = "id") Long id,Model model) {
		User user=this.userService.findOne(id);
		model.addAttribute("user", user);
		return "watched_movies.html";
	}
	@GetMapping("/account/{id}/reservations")
	public String reservations(@PathVariable(name = "id") Long id,Model model) {
		User user=this.userService.findOne(id);
		model.addAttribute("user", user);
		return "reservations.html";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
		User user;
		try {
			user=this.userService.checkEmail(userDTO);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		if(user==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(!(this.userService.login(userDTO, user))) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PutMapping("/rate")
	public ResponseEntity<?> rate(@RequestBody RatingDTO ratingDTO){
		try{
			this.userService.RateIt(ratingDTO.getRating(), ratingDTO.getMovie_id(),ratingDTO.getWatched_movie_id());
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/cancel_reservation")
	public ResponseEntity<?> cancel(@RequestBody ReservationDTO reservationDTO){
		try {
			this.userService.cancelReservation(reservationDTO.getUser_id(),reservationDTO.getProjection_id());
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/account/{id}/managers")
	public String managers(@PathVariable(name = "id") Long id,Model model) {
		List<User> users=this.userService.getManagers();
		User user=this.userService.findOne(id);
		model.addAttribute("managers", users);
		model.addAttribute("user",user);
		return "managers.html";
	}
	
	@GetMapping("/account/{id}/register_man")
	public String register_man(@PathVariable(name = "id") Long id,Model model) {
		List<Cinema> cinemas=this.cinemaService.findAll();
		User user=this.userService.findOne(id);
		model.addAttribute("cinemas", cinemas);
		model.addAttribute("user",user);
		return "register_man.html";
	}
	@DeleteMapping("/remove_manager/{id}")
	public ResponseEntity<?> remove_man(@PathVariable(name = "id") Long id) {	
		try{
			this.userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/register-manager")
	public ResponseEntity<?> create_manager(@RequestBody ManagerDTO managerDTO) {
		try {
			this.userService.saveManager(managerDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/reserve_ticket")
	public ResponseEntity<?> reserve_ticket(@RequestBody ReservationDTO reservationDTO){
		boolean flag=false;
		try {
			flag=this.userService.addReservation(reservationDTO.getUser_id(),reservationDTO.getProjection_id());
			if(flag)
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.CONFLICT);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/account/{id}/cinema")
	public String manager_cinemas(@PathVariable(name = "id") Long id,Model model) {
		User user=this.userService.findOne(id);
		Cinema cinema=user.getCinema();
		model.addAttribute("cinema", cinema);
		model.addAttribute("user",user);
		return "man_cinemas.html";
	}
	@DeleteMapping("/delete_room/{cinema_id}/room/{room_id}")
	public ResponseEntity<?> delete_room(@PathVariable(name = "cinema_id") Long cinema_id,@PathVariable(name = "room_id") Long room_id) {	
		try{
			if(this.roomService.deleteById(cinema_id,room_id))
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.CONFLICT);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/add_room")
	public ResponseEntity<?> add_room(@RequestBody RoomDTO room) {
		try {
			userService.addRoom(room);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	@PutMapping("/edit_room")
	public ResponseEntity<?> edit_room(@RequestBody Room room){
		try{
			this.userService.editRoom(room);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/account/{id}/cinema/room/{room_id}")
	public String room_editing(@PathVariable(name = "id") Long id,@PathVariable(name = "room_id") Long room_id,Model model) {
		Room room=this.roomService.findOne(room_id);
		model.addAttribute("room", room);
		return "room.html";
	}
	@GetMapping("/account/{id}/schedule")
	public String schedule(@PathVariable(name="id")Long id,Model model) {
		User user=this.userService.findOne(id);
		Cinema cinema=user.getCinema();
		List<Movie> movies=this.movieService.findAll();
		model.addAttribute("user", user);
		model.addAttribute("cinema", cinema);
		model.addAttribute("movies", movies);
		return "schedule.html";
	}
	
	@PostMapping("/add_projection")
	public ResponseEntity<?> add_projection(@RequestBody ProjectionDTO projectionDTO) {
		try {
			this.projectionService.addProjection(projectionDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
}