package bookshow.service;

import bookshow.domain.props.NewProp;
import bookshow.domain.props.UsedProp;
import bookshow.domain.users.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@Service
public interface NewPropService {

    List<NewProp> findAll();

    List<NewProp> findByUserIsNull();

    List<NewProp> findByUser(User user);

    NewProp findOne(Long id);

    NewProp save(NewProp newProp);

    void delete(Long id);

    NewProp reserve(NewProp newProp, String username);
}
