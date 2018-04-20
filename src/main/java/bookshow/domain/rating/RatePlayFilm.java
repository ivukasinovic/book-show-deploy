package bookshow.domain.rating;

import javax.persistence.EmbeddedId;

public class RatePlayFilm {

	@EmbeddedId
	private UserPlayFilm userPlayFilm;
}
