package bookshow.service;

import java.util.List;

import bookshow.domain.Auditorium;

public interface AuditoriumService {
	List<Auditorium> findAll();

	Auditorium findOne(Long id);

	Auditorium save(Auditorium auditorium);

    void delete(Long id);

	List<Auditorium> findByShowId(Long showId);
}
