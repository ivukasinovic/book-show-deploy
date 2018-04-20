package bookshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.Auditorium;
import bookshow.domain.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{
	List<Seat> findByAuditorium(Auditorium auditorium);
	Seat findById(Long id);
	List<Seat> findAll();
	Seat save(Seat seat);
}
