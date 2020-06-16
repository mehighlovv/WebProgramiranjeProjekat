package project.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.cinema.model.Projection;
import project.cinema.repository.ProjectionRepository;

@Service
public class ProjectionService {
	@Autowired
	private ProjectionRepository projectionRepository;
	
	public Projection findOne(long id) {
		Projection projection=this.projectionRepository.getOne(id);
		return projection;
	}
	
	public List<Projection> findAll(){
		List<Projection> projections=this.projectionRepository.findAll();
		return projections;
	}
	public Projection save(Projection projection) {
		return this.projectionRepository.save(projection);
	}
}
