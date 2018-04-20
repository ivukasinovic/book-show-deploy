package bookshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.movie.PlayFilm;

public interface PlayFilmRepository  extends JpaRepository<PlayFilm, Long>{

	List<PlayFilm> findByShowId(Long id);

}
