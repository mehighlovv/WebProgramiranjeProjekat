package project.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.cinema.model.Room;

public interface RoomRepository extends JpaRepository<Room,Long>{

}
