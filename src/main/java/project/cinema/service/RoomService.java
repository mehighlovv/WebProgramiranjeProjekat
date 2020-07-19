package project.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.cinema.model.Cinema;
import project.cinema.model.Room;
import project.cinema.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;
	 
	@Autowired
	private CinemaService cinemaService;
	
	public Room findOne(Long id){
		Room room=this.roomRepository.findById(id).get();
		return room;
	}
	public List<Room> findAll(){
		List<Room> rooms=this.roomRepository.findAll();
		return rooms;
	}
	public Room save(Room room) {
		return this.roomRepository.save(room);
	}
	public void editRoom(Room room) {
		this.roomRepository.updateRoom(room.getId(),room.getCapacity(),room.getMark());
	}
	public boolean deleteById(Long cinema_id,Long room_id) {
		try {
			Cinema cinema=this.cinemaService.findOne(cinema_id);
			Room room=this.roomRepository.findById(room_id).get();
			cinema.getRooms().remove(room);
			room.getProjections().clear();
			this.roomRepository.deleteById(room_id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
