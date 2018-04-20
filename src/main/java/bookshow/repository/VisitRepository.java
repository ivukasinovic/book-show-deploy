package bookshow.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.users.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long>{
	Visit findById(Long Id);
	List<Visit> findByUserUsername(String username);
	List<Visit> findByShowName(String showName);
	List<Visit> findByShowIdAndDate(Long id, Date date);
	List<Visit> findByShowIdAndDateGreaterThanEqualAndDateLessThanEqual(Long showIdLong, Date weekAgo, Date today);
	
}
