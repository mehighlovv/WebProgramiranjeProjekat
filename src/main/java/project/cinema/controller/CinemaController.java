package project.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import project.cinema.dto.CinemaDTO;
import project.cinema.model.Cinema;
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

}
