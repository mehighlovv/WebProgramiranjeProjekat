package project.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import project.cinema.model.Movie;
import project.cinema.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/movies")
	public String movies(Model model) {
		List<Movie> movies=this.movieService.findAll();
		model.addAttribute("movies", movies);
		return "movies.html";
	}
}
