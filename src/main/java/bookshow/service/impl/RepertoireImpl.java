package bookshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshow.domain.movie.DateShow;
import bookshow.domain.movie.Repertoire;
import bookshow.repository.RepertoireRepository;
import bookshow.service.RepertoireService;

@Service
public class RepertoireImpl implements RepertoireService{
	@Autowired
    private RepertoireRepository repertoireRepository;
	
	@Override
	public List<Repertoire> findAll() {
		// TODO Auto-generated method stub
		return repertoireRepository.findAll();
	}

	@Override
	public Repertoire save(Repertoire repertoire) {
		// TODO Auto-generated method stub
		return repertoireRepository.save(repertoire);
	}

	@Override
	public Repertoire findOne(DateShow dateShow) {
		// TODO Auto-generated method stub
		return repertoireRepository.findOne(dateShow);
	}

	@Override
	public void delete(DateShow dateShow) {
		// TODO Auto-generated method stub
		repertoireRepository.delete(dateShow);
		
	}



}
