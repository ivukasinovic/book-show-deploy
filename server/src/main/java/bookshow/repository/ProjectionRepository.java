package bookshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.movie.Projection;
import bookshow.domain.movie.Repertoire;

public interface ProjectionRepository extends JpaRepository<Projection, Long>{
	List<Projection> findByRepertoire(Repertoire repertoire);
}
