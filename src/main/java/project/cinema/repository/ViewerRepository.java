package project.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.cinema.model.Viewer;

public interface ViewerRepository extends JpaRepository<Viewer,Long> {
	

}
