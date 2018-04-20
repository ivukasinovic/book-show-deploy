package bookshow.service.impl;

import bookshow.domain.users.Rating;
import bookshow.repository.RatingRepository;
import bookshow.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ivan V. on 17-Apr-18
 */
@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getCurrentRating() {
        Rating rating = ratingRepository.findTopByOrderByDateDesc();
        return rating;
    }
}
