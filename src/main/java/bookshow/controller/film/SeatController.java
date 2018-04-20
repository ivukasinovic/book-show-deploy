package bookshow.controller.film;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.Auditorium;
import bookshow.domain.Seat;
import bookshow.domain.movie.Ticket;
import bookshow.service.AuditoriumService;
import bookshow.service.SeatService;
import bookshow.service.TicketService;
@RestController
public class SeatController {
	@Autowired
	private SeatService SeatService;
	
	@Autowired
	private AuditoriumService AuditoriumService;
	
	@Autowired
	private TicketService TicketService;
	
	
	@RequestMapping(value = "/getAllSeats/{auditoriumId}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Seat>> getAllSeats(@PathVariable("auditoriumId") String auditoriumId){	
		ArrayList<Seat> retVal = new ArrayList<Seat>();
		Auditorium a = AuditoriumService.findOne(Long.parseLong(auditoriumId));	
		List<Seat> tmp = SeatService.findByAuditorium(a);
		
		for(Seat s : tmp) {
			retVal.add(s);
		}

		return new ResponseEntity<>(retVal,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getResevedSeatIds/{auditoriumId}/{projectionId}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Seat>> getResevedSeatIds(
			@PathVariable("projectionId") String projectionId,@PathVariable("auditoriumId") String auditoriumId) {
		ArrayList<Seat> retVal = new ArrayList<Seat>();
		List<Ticket> tickets = TicketService.findAll();
		for(Ticket t : tickets) {
			if(t.getSeat().getAuditorium().getId().equals(Long.parseLong(auditoriumId))) {
				retVal.add(t.getSeat());
			}
			if(t.getProjection().getId().equals(Long.parseLong(projectionId)) && t.getPurchased() != null) {
				Seat s = SeatService.findById(t.getSeat().getId());
				if(s.getAuditorium().getId().equals(Long.parseLong(auditoriumId))) {
					retVal.add(s);
				}
			}

		}
		
		
		return new ResponseEntity<>(retVal,HttpStatus.OK);
	}
	
}
