package bookshow.service;

import java.util.Date;
import java.util.List;

import bookshow.domain.users.Visit;

public interface VisitService{

	Visit findById(Long Id);
	List<Visit> findByUserUsername(String username);
	List<Visit> findByShowName(String showName);
	Visit save(Visit visit);
	List<Visit> fintAll();
	void delete(Visit visit);
	List<Visit> findByShowIdAndDate(Long showIdLong, Date date);
	List<Visit> findByShowIdAndDateGreaterThanEqualAndDateLessThanEqual(Long showIdLong, Date weekAgo, Date today);
}
