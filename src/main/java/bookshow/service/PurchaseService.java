package bookshow.service;

import java.util.Date;
import java.util.List;

import bookshow.domain.movie.Purchase;

public interface PurchaseService {
	List<Purchase> findAll();

	Purchase findOne(Long id);

	Purchase save(Purchase purchase);

    void delete(Long id);
    
	List<Purchase> findByDateGreaterThanEqualAndDateLessThanEqual(Date start, Date end);

}
