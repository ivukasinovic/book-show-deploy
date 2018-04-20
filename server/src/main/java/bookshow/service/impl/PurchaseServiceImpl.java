package bookshow.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshow.domain.movie.Purchase;
import bookshow.repository.PurchaseRepository;
import bookshow.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired PurchaseRepository purchaseRepository;

	@Override
	public List<Purchase> findAll() {
		// TODO Auto-generated method stub
		return purchaseRepository.findAll();
	}

	@Override
	public Purchase findOne(Long id) {
		// TODO Auto-generated method stub
		return purchaseRepository.findOne(id);
	}

	@Override
	public Purchase save(Purchase purchase) {
		// TODO Auto-generated method stub
		return purchaseRepository.save(purchase);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		purchaseRepository.delete(id);
	}

	@Override
	public List<Purchase> findByDateGreaterThanEqualAndDateLessThanEqual(Date start, Date end) {
		// TODO Auto-generated method stub
		return purchaseRepository.findByDateGreaterThanEqualAndDateLessThanEqual(start, end);
	}

}
