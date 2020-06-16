package project.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import project.cinema.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	 User findByEmail(String email);
}
