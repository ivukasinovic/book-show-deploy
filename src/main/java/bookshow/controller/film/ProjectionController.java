package bookshow.controller.film;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.DTOs.DeletedResponse;
import bookshow.domain.movie.Projection;
import bookshow.domain.movie.Repertoire;
import bookshow.service.ProjectionService;
import bookshow.service.TicketService;

@RestController
@RequestMapping(value="/projection")
public class ProjectionController {
	
	@Autowired
	ProjectionService projectionService;
	
	@Autowired
	TicketService ticketService;
	
	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/get/{projectionId}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Projection> getProjection(@PathVariable String projectionId){
		Long longId = new Long(Integer.parseInt(projectionId));
		return new ResponseEntity<>(projectionService.findOne(longId), HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/save", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Projection> saveProjection(@RequestBody Projection projection, BindingResult result){
		return new ResponseEntity<>(projectionService.save(projection), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/update", 
			method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Projection> updateProjection(@RequestBody Projection projection){
		return new ResponseEntity<>(projectionService.save(projection), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/delete/{id}", 
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeletedResponse> deleteProjection(@PathVariable String id){
		
		Long longId = new Long(Integer.parseInt(id));
		if(ticketService.findByProjectionId(longId).isEmpty()){
			projectionService.delete(longId);
			return new ResponseEntity<>(new DeletedResponse("deleted"), HttpStatus.OK);
		}else{
			return new ResponseEntity<>(new DeletedResponse("notDeleted"), HttpStatus.OK);
		}
	}
	
	@RequestMapping(
			value = "/get-by-repertoire", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Projection>> getProjectionsByRepertoire(@RequestBody Repertoire repertoire){
		return new ResponseEntity<>(projectionService.findByRepertoire(repertoire), HttpStatus.OK);
	}
}


