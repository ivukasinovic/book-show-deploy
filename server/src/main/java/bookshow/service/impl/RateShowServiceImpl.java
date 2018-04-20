package bookshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshow.domain.rating.RateShow;
import bookshow.domain.rating.UserShow;
import bookshow.repository.RateShowRepository;
import bookshow.service.RateShowService;

@Service
public class RateShowServiceImpl implements RateShowService{
	
	@Autowired 
	private RateShowRepository rateShowRepository;

	@Override
	public List<RateShow> findAll() {
		// TODO Auto-generated method stub
		return rateShowRepository.findAll();
	}

	@Override
	public RateShow findOne(UserShow userShow) {
		// TODO Auto-generated method stub
		return rateShowRepository.findOne(userShow);
	}

	@Override
	public RateShow save(RateShow rateShow) {
		// TODO Auto-generated method stub
		return rateShowRepository.save(rateShow);
	}

	@Override
	public void delete(UserShow userShow) {
		// TODO Auto-generated method stub
		rateShowRepository.delete(userShow);
	}

	@Override
	public List<RateShow> findByUserShowShowId(Long showIdLong) {
		// TODO Auto-generated method stub
		return rateShowRepository.findByUserShowShowId(showIdLong);
	}

}
