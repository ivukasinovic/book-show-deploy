package bookshow.service;

import bookshow.domain.users.Rating;

/**
 * Created by Ivan V. on 17-Apr-18
 */
public interface RatingService {

    Rating save(Rating rating);

    Rating getCurrentRating();
}
