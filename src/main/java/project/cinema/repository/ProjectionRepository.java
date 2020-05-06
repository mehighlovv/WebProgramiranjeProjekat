package project.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.cinema.model.Projection;

public interface ProjectionRepository extends JpaRepository<Projection,Long> {

}
