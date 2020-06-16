package project.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import project.cinema.dto.UserDTO;
import project.cinema.model.User;
import project.cinema.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;	
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
}
