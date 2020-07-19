package project.cinema.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.cinema.model.Projection;
@Repository
public interface ProjectionRepository extends JpaRepository<Projection,Long> {
	List<Projection> findByCinemaId(Long id);
	
}
