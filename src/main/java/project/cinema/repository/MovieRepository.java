package project.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.cinema.model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long>{
	

}
