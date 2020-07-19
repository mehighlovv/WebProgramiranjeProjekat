package project.cinema.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.cinema.dto.ProjectionDTO;
import project.cinema.model.Cinema;
import project.cinema.model.Movie;
import project.cinema.model.Projection;
import project.cinema.model.Room;
import project.cinema.repository.ProjectionRepository;

@Service
public class ProjectionService {
	@Autowired
	private ProjectionRepository projectionRepository;
	
	@Autowired
	private CinemaService cinemaService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private RoomService roomService;
	
	public Projection findOne(Long id) {
		Projection projection=this.projectionRepository.findById(id).get();
		return projection;
	}
	
	public List<Projection> findAll(){
		List<Projection> projections=this.projectionRepository.findAll();
		return projections;
	}
	public Projection save(Projection projection) {
		return this.projectionRepository.save(projection);
	}
	
	public List<Projection> findByCinemaId(Long id)
	{
		return projectionRepository.findByCinemaId(id);
	}
	
	public void addProjection(ProjectionDTO projectionDTO) {
		Projection projection=new Projection();
		Cinema cinema=this.cinemaService.findOne(projectionDTO.getCinema_id());
		Movie movie=this.movieService.findOne(projectionDTO.getMovie_id());
		Room room=this.roomService.findOne(projectionDTO.getRoom_id());
		projection.setCinema(cinema);
		projection.setMovie(movie);
		projection.getRooms().add(room);
		projection.setDay(projectionDTO.getDay());
		projection.setPrice(projectionDTO.getPrice());
		projection.setTime(projectionDTO.getTime());
		projection.setViewers(null);
		this.projectionRepository.save(projection);
		cinema.getSchedule().add(projection);
		room.getProjections().add(projection);
		
	}
}
