package bookshow.service;

import bookshow.domain.Show;
import bookshow.domain.ShowType;

import java.util.List;

/**
 * Created by Ivan V. on 01-Feb-18
 */
public interface ShowService {
    List<Show> findAll();

    List<Show> findByType(ShowType type);

    Show findByName(String name);

    Show findOne(Long id);

    Show save(Show show);

    void delete(Long id);
}
