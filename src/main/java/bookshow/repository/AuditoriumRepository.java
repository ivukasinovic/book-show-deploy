package bookshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.Auditorium;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long>{

	List<Auditorium> findByShowId(Long showId);

}
