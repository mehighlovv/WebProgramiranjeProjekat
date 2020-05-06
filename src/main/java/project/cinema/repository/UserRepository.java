package project.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.cinema.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
