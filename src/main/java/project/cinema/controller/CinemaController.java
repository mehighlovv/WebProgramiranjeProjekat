package project.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import project.cinema.dto.CinemaDTO;
import project.cinema.model.Cinema;
import project.cinema.model.Room;
import project.cinema.service.CinemaService;

@Controller
public class CinemaController {
	
	@Autowired
	private CinemaService cinemaService;
	
	@GetMapping("/cinemas")
	public String welcome1(Model model) {
		List<Cinema> cinemas=this.cinemaService.findAll();
		model.addAttribute("cinemas", cinemas);
		return "cinemas.html";
	}
	
	@PostMapping("/add-cinema")
	public ResponseEntity<?> add(@RequestBody CinemaDTO cinemaDTO){
		Cinema cinema=cinemaService.save(Cinema.getCinemaByDTO(cinemaDTO));
		if (cinema == null)
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		return new ResponseEntity<Cinema>(cinema, HttpStatus.OK);
	}
	@DeleteMapping("/cinemas/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
		if(cinemaService.deleteById(id))
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	@GetMapping("/cinema/{id}")
	public String cinema(@PathVariable(name="id") Long id,Model model) {
		Cinema cinema=this.cinemaService.findOne(id);
		model.addAttribute("cinema", cinema);
		return "cinema.html";
	}
	@PutMapping("/edit_cinema")
	public ResponseEntity<?> edit_cinema(@RequestBody Cinema cinema){
		try{
			this.cinemaService.editCinema(cinema);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
