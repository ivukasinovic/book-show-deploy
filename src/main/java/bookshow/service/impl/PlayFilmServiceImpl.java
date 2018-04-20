package bookshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshow.domain.movie.PlayFilm;
import bookshow.repository.PlayFilmRepository;
import bookshow.service.PlayFilmService;

@Service
public class PlayFilmServiceImpl implements PlayFilmService {
	@Autowired
    private PlayFilmRepository playFilmRepository;
	
	@Override
	public List<PlayFilm> findAll() {
		// TODO Auto-generated method stub
		return playFilmRepository.findAll();
	}

	@Override
	public PlayFilm findOne(Long id) {
		// TODO Auto-generated method stub
		return playFilmRepository.findOne(id);
	}

	@Override
	public PlayFilm save(PlayFilm playfilm) {
		// TODO Auto-generated method stub
		return playFilmRepository.save(playfilm);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		playFilmRepository.delete(id);
	}

	@Override
	public List<PlayFilm> findByShowId(Long id) {
		// TODO Auto-generated method stub
		return playFilmRepository.findByShowId(id);
	}

}
