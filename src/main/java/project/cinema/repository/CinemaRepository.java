package project.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.cinema.model.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema,Long> {

}
