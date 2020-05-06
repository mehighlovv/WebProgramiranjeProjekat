package project.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.cinema.model.Watched_movie;

public interface Watched_movieRepository extends JpaRepository<Watched_movie,Long>{

}
