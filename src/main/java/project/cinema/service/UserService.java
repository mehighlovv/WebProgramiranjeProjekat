package project.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.cinema.dto.UserDTO;
import project.cinema.model.User;
import project.cinema.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User findOne(long id){
		User user=this.userRepository.getOne(id);
		return user;
	}
	public List<User> findAll(){
		List<User> users=this.userRepository.findAll();
		return users;
	}
	public User save(User user){
		return this.userRepository.save(user);
	}
	public boolean login(UserDTO userDTO,User user) {
		if(user.getPassword().equals(userDTO.getPassword())){
			return true;
		}
		return false;
	}
	public User checkEmail(UserDTO userDTO) {
		User user=this.userRepository.findByEmail(userDTO.getEmail());
		if(user==null)
			return null;
		return user;
	}
}
