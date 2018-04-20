package bookshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.Auditorium;
import bookshow.service.AuditoriumService;

@RestController
@RequestMapping(value = "/auditorium")
public class AuditoriumController {

	@Autowired
	private AuditoriumService auditoriumService;
	
	@RequestMapping(
			value = "/get-by-show/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Auditorium>> getAuditoriumsByShow(@PathVariable String id){
		Long longId = new Long(Integer.parseInt(id));
		return new ResponseEntity<>(auditoriumService.findByShowId(longId), HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Auditorium> getAuditorium(@PathVariable String id){
		Long longId = new Long(Integer.parseInt(id));
		return new ResponseEntity<>(auditoriumService.findOne(longId), HttpStatus.OK);
	}
}
