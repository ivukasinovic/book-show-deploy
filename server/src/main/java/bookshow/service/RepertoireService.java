package bookshow.service;

import java.util.List;

import bookshow.domain.movie.DateShow;
import bookshow.domain.movie.Repertoire;


public interface RepertoireService {
	List<Repertoire> findAll();

	Repertoire findOne(DateShow dateShow);

	Repertoire save(Repertoire repertoire);

    void delete(DateShow dateShow);
}
