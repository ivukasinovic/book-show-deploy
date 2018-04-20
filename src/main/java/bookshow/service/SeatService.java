package bookshow.service;

import java.util.List;

import bookshow.domain.Auditorium;
import bookshow.domain.Seat;

public interface SeatService {
	List<Seat> findByAuditorium(Auditorium auditorium);
	Seat findById(Long id);
	List<Seat> findAll();
	Seat save(Seat seat);
}
