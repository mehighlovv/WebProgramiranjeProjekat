package project.cinema.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.cinema.model.Roles;
import project.cinema.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	 User findByEmail(String email);
	 
	 List<User> findByRole(Roles role);

}
