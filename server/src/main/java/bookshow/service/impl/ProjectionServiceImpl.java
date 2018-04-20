package bookshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshow.domain.movie.Projection;
import bookshow.domain.movie.Repertoire;
import bookshow.repository.ProjectionRepository;
import bookshow.service.ProjectionService;

@Service
public class ProjectionServiceImpl implements ProjectionService{
	@Autowired
    private ProjectionRepository projectionRepository;
	
	
	@Override
	public List<Projection> findAll() {
		// TODO Auto-generated method stub
		return projectionRepository.findAll();
	}

	@Override
	public Projection findOne(Long id) {
		// TODO Auto-generated method stub
		return projectionRepository.findOne(id);
	}

	@Override
	public Projection save(Projection projection) {
		// TODO Auto-generated method stub
		return projectionRepository.save(projection);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		projectionRepository.delete(id);
	}

	@Override
	public List<Projection> findByRepertoire(Repertoire repertoire) {
		// TODO Auto-generated method stub
		return projectionRepository.findByRepertoire(repertoire);
	}

}
