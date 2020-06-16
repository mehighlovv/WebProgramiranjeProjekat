package project.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.cinema.model.Room;
import project.cinema.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	public Room findOne(long id){
		Room room=this.roomRepository.getOne(id);
		return room;
	}
	public List<Room> findAll(){
		List<Room> rooms=this.roomRepository.findAll();
		return rooms;
	}
	public Room save(Room room) {
		return this.roomRepository.save(room);
	}
}
