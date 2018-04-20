package bookshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.movie.DateShow;
import bookshow.domain.movie.Repertoire;

public interface RepertoireRepository  extends JpaRepository<Repertoire, DateShow> {

}
