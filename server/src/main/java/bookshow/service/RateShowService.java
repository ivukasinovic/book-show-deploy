package bookshow.service;

import java.util.List;

import bookshow.domain.rating.RateShow;
import bookshow.domain.rating.UserShow;

public interface RateShowService {
	List<RateShow> findAll();

	RateShow findOne(UserShow userShow);

	RateShow save(RateShow rateShow);

    void delete(UserShow userShow);

	List<RateShow> findByUserShowShowId(Long showIdLong);
}
