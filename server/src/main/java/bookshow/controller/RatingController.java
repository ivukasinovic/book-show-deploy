package bookshow.controller;

import bookshow.domain.users.Rating;
import bookshow.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ivan V. on 17-Apr-18
 */
@RestController
@RequestMapping(value = "/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PreAuthorize("hasAuthority('ADMINSYS')")
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> setRating(@Validated @RequestBody Rating rating, Errors errors) {
        if(errors.hasErrors()){
            return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
        }
        if ((rating.getBronze() > rating.getSilver()) || (rating.getSilver() > rating.getGold())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        rating.setDate(new java.util.Date());
        Rating savedRating = ratingService.save(rating);
        return new ResponseEntity<>(savedRating, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/get-current",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> getRatings() {
        Rating rating = ratingService.getCurrentRating();
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }
}
