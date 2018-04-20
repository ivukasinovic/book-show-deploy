package bookshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshow.domain.Auditorium;
import bookshow.domain.Seat;
import bookshow.service.SeatService;
import bookshow.repository.SeatRepository;

@Service
public class SeatServiceImpl implements SeatService{

	@Autowired 
	SeatRepository SeatRepository;
	
	@Override
	public List<Seat> findByAuditorium(Auditorium auditorium) {
		return SeatRepository.findByAuditorium(auditorium);
	}

	@Override
	public Seat findById(Long id) {
		return SeatRepository.findOne(id);
	}

	@Override
	public List<Seat> findAll() {
		return SeatRepository.findAll();
	}

	@Override
	public Seat save(Seat seat) {
		return SeatRepository.save(seat);
	}

}
