package bookshow.controller.film;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.DTOs.IntegerDTO;
import bookshow.domain.DTOs.MonthlyProfit;
import bookshow.domain.DTOs.TwoDates;
import bookshow.domain.movie.Purchase;
import bookshow.domain.movie.Ticket;
import bookshow.domain.users.Visit;
import bookshow.service.PurchaseService;
import bookshow.service.TicketService;
import bookshow.service.VisitService;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired 
	private TicketService ticketService;
	
	@Autowired
	private VisitService visitService;

	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/get-profit/{showId}", 
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MonthlyProfit> getProjection(@RequestBody TwoDates twoDates, @PathVariable String showId){
		List<Purchase> purchases = purchaseService.findByDateGreaterThanEqualAndDateLessThanEqual(twoDates.getStartDate(),  twoDates.getEndDate());

		double sum = 0;
		Long showIdLong = new Long(Integer.parseInt(showId));
		for(int i = 0; i < purchases.size(); i++){
			Ticket ticket = ticketService.findByPurchasedId(purchases.get(i).getId());
			if(ticket != null){
				if(ticket.getSeat().getAuditorium().getShow().getId().equals(showIdLong))
					if(ticket.getDiscount() > 0)
						sum += ticket.getProjection().getPrice() * (100 - ticket.getDiscount())/100;
					else
						sum += ticket.getProjection().getPrice();
			}
		}
		return new ResponseEntity<>(new MonthlyProfit(sum), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/get-todays-visits/{showId}", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IntegerDTO> getTodaysVisits(@PathVariable String showId){
		Date date = new Date();
		Long showIdLong = new Long(Integer.parseInt(showId));
		List<Visit> visitsToShow = visitService.findByShowIdAndDate(showIdLong, date);
		
		return new ResponseEntity<>(new IntegerDTO(visitsToShow.size()), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/get-this-weeks-visits/{showId}", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IntegerDTO> getThisWeeksVisits(@PathVariable String showId){
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DATE, -7);
		Date weekAgo = cal.getTime();
		
		Long showIdLong = new Long(Integer.parseInt(showId));
		List<Visit> visitsToShow = visitService.findByShowIdAndDateGreaterThanEqualAndDateLessThanEqual(showIdLong, weekAgo, today);
		
		return new ResponseEntity<>(new IntegerDTO(visitsToShow.size()), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/get-this-months-visits/{showId}", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IntegerDTO> getThisMonthsVisits(@PathVariable String showId){
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DATE, -30);
		Date weekAgo = cal.getTime();
		
		Long showIdLong = new Long(Integer.parseInt(showId));
		List<Visit> visitsToShow = visitService.findByShowIdAndDateGreaterThanEqualAndDateLessThanEqual(showIdLong, weekAgo, today);
		
		return new ResponseEntity<>(new IntegerDTO(visitsToShow.size()), HttpStatus.OK);
	}
	
	
}
