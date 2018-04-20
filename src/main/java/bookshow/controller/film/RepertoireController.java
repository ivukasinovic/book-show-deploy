package bookshow.controller.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.movie.DateShow;
import bookshow.domain.movie.Repertoire;
import bookshow.service.RepertoireService;


@RestController
@RequestMapping(value="/repertoire")
public class RepertoireController {
	@Autowired
	RepertoireService repertoireService;
	
	@RequestMapping(
			value = "/get", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Repertoire> getShowsRepertoire(@RequestBody DateShow dateShow){
		return new ResponseEntity<>(repertoireService.findOne(dateShow), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/save", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Repertoire> saveRepertoire(@RequestBody Repertoire repertoire){
		return new ResponseEntity<>(repertoireService.save(repertoire), HttpStatus.OK);
	}
}
