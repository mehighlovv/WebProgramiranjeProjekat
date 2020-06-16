package project.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.cinema.model.Viewer;
import project.cinema.repository.ViewerRepository;

@Service
public class ViewerService {

	@Autowired
	private ViewerRepository viewerRepository;
	
	public Viewer findOne(long id) {
		Viewer viewer=this.viewerRepository.getOne(id);
		return viewer;
	}
	
	public List<Viewer> findAll(){
		List<Viewer> viewers=this.viewerRepository.findAll();
		return viewers;
	}
	
	public Viewer save(Viewer viewer){
		return this.viewerRepository.save(viewer);
	}
}
