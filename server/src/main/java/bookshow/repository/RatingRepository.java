package bookshow.repository;

import bookshow.domain.users.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 17-Apr-18
 */
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findAll();

    Rating findTopByOrderByDateDesc();
}
