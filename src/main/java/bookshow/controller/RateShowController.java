package bookshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.Show;
import bookshow.domain.DTOs.DoubleDTO;
import bookshow.domain.rating.RateShow;
import bookshow.domain.rating.UserShow;
import bookshow.domain.users.User;
import bookshow.service.RateShowService;
import bookshow.service.ShowService;
import bookshow.service.UserService;

@RestController
@RequestMapping(value = "/rateshow")
public class RateShowController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private RateShowService rateShowService;
	
	@RequestMapping(
            value = "/get/{username}/{showId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoubleDTO> getUsersRating(@PathVariable String username, @PathVariable String showId){
		User user = userService.findByUsername(username);
		Long longId = new Long(Integer.parseInt(showId));
		Show show = showService.findOne(longId);
		UserShow userShow = new UserShow(user, show);
		RateShow rateShow = rateShowService.findOne(userShow);
		if(rateShow == null)
	        return new ResponseEntity<>(new DoubleDTO(0), HttpStatus.OK);
		else
			return new ResponseEntity<>(new DoubleDTO(rateShow.getRating()), HttpStatus.OK);
	}
	
	@RequestMapping(
            value = "/save/{username}/{showId}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RateShow> rateAShow(@RequestBody RateShow rateShow, @PathVariable String username, @PathVariable String showId) {
		Long showIdLong = new Long(Integer.parseInt(showId));
		User user = userService.findByUsername(username);
		Show show = showService.findOne(showIdLong);
		UserShow userShow = new UserShow(user, show);
		rateShow.setUserShow(userShow);
        return new ResponseEntity<>(rateShowService.save(rateShow), HttpStatus.OK);
    }
	
	@RequestMapping(
            value = "/calculate-show-rating/{showId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoubleDTO> calculateShowRating(@PathVariable String showId) {
		Long showIdLong = new Long(Integer.parseInt(showId));
		List<RateShow> showsRatings = rateShowService.findByUserShowShowId(showIdLong);
		double sum = 0;
		for(int i = 0; i < showsRatings.size(); i++){
			sum += showsRatings.get(i).getRating();
		}
		
        return new ResponseEntity<>(new DoubleDTO(sum / (double)showsRatings.size()), HttpStatus.OK);
    }

}
