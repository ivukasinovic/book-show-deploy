package bookshow.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.movie.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

	List<Purchase> findByDateGreaterThanEqualAndDateLessThanEqual(Date start, Date end);

}
