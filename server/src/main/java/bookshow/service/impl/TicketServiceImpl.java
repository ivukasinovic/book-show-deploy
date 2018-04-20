package bookshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshow.domain.movie.Ticket;
import bookshow.repository.TicketRepository;
import bookshow.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	TicketRepository ticketRepository;
	
	@Override
	public List<Ticket> findAll() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public Ticket findOne(Long id) {
		// TODO Auto-generated method stub
		return ticketRepository.findOne(id);
	}

	@Override
	public Ticket save(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ticketRepository.delete(id);
	}

	@Override
	public List<Ticket> findByProjectionId(Long id) {
		// TODO Auto-generated method stub
		return ticketRepository.findByProjectionId(id);
	}

	@Override
	public List<Ticket> findByProjectionAuditoriumShowIdAndDiscountGreaterThanAndPurchasedIsNull(Long id, double value) {
		// TODO Auto-generated method stub
		return ticketRepository.findByProjectionAuditoriumShowIdAndDiscountGreaterThanAndPurchasedIsNull(id, value);
	}

	@Override
	public Ticket findByPurchasedId(Long id) {
		// TODO Auto-generated method stub
		return ticketRepository.findByPurchasedId(id);
	}

	@Override
	public List<Ticket> findByProjectionIdAndPurchasedIsNotNull(Long id) {
		return ticketRepository.findByProjectionIdAndPurchasedIsNotNull(id);
	}

}
