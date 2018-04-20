package bookshow.controller.film;



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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bookshow.domain.movie.PlayFilm;
import bookshow.service.PlayFilmService;

@RestController
public class PlayFilmController {
	
	@Autowired
	PlayFilmService playFilmService;
	
	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/new-play-film", 
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlayFilm> createPlayFilm(@RequestBody PlayFilm playfilm){
		playfilm.setAverageScore(0);
		PlayFilm saved = playFilmService.save(playfilm);
		
		return new ResponseEntity<>(saved, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/update-play-film", 
			method = RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlayFilm> updatePlayFilm(@RequestBody PlayFilm playfilm){
		playfilm.setAverageScore(0);
		PlayFilm saved = playFilmService.save(playfilm);
		
		return new ResponseEntity<>(saved, HttpStatus.OK);
	}

	@RequestMapping(
			value = "/get-playfilms-by-show/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PlayFilm>> getShowsRepertoire(@PathVariable String id){
		Long longId = new Long(Integer.parseInt(id));
		return new ResponseEntity<>(playFilmService.findByShowId(longId), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/get-play-film/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlayFilm> getPlayFilmById(@PathVariable String id){
		Long longId = new Long(Integer.parseInt(id));
		return new ResponseEntity<>(playFilmService.findOne(longId), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMINSHOW')")
	@RequestMapping(
			value = "/delete-play-film/{id}", 
			method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePlayFilmById(@PathVariable String id){
		Long longId = new Long(Integer.parseInt(id));
		playFilmService.delete(longId);
	}

}
