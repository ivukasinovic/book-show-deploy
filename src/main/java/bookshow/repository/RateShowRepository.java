package bookshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.rating.RateShow;
import bookshow.domain.rating.UserShow;

public interface RateShowRepository extends JpaRepository<RateShow, UserShow>{

	List<RateShow> findByUserShowShowId(Long showIdLong);

}
