package bookshow.service;

import java.util.List;

import bookshow.domain.movie.Projection;
import bookshow.domain.movie.Repertoire;

public interface ProjectionService {
	List<Projection> findAll();

	Projection findOne(Long id);

	Projection save(Projection projection);

    void delete(Long id);
    
    List<Projection> findByRepertoire(Repertoire repertoire);
    
}
