package bookshow.controller;

import bookshow.domain.Show;
import bookshow.domain.ShowType;
import bookshow.domain.rating.RateShow;
import bookshow.domain.users.User;
import bookshow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value="/shows")
public class ShowController {

	@Autowired
	ShowService showService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Show>> getShowTheatre(@RequestParam(value = "type") String pathvar) {;
		List<Show> retval = null;
		if (pathvar.equals("theatre"))
			retval = showService.findByType(ShowType.THEATRE);
		else if(pathvar.equals("cinema"))
            retval = showService.findByType(ShowType.CINEMA);
		else if(pathvar.equals("all")){
		    retval = showService.findAll();
        }

		return new ResponseEntity<>(retval, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/{id}",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Show> getShow(@PathVariable String id){
		Long longId = new Long(Integer.parseInt(id));
		return new ResponseEntity<>(showService.findOne(longId), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/edit",
			method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Show> updateShow(@RequestBody Show show){
		return new ResponseEntity<>(showService.save(show), HttpStatus.OK);
	}

	@PreAuthorize("hasAnyAuthority('ADMINSYS')")
	@RequestMapping(
	        method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Show> createShow(@RequestBody Show show, Principal principal){
	    Show savedShow = showService.save(show);
	    return  new ResponseEntity<>(savedShow, HttpStatus.CREATED);
    }
	
	

}
