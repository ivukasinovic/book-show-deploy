package bookshow.repository;

import bookshow.domain.props.NewProp;
import bookshow.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface NewPropRepository extends JpaRepository<NewProp, Long> {
    List<NewProp> findAll();

    List<NewProp> findByUserIsNull();

    List<NewProp> findByUser(User user);

    NewProp findOne(Long id);

    NewProp save(NewProp newProp);

    void delete(Long id);


}
