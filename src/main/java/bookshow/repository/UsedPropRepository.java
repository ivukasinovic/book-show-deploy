package bookshow.repository;

import bookshow.domain.props.UsedProp;
import bookshow.domain.props.UsedPropStatus;
import bookshow.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface UsedPropRepository extends JpaRepository<UsedProp, Long> {
    List<UsedProp> findAll();

    List<UsedProp> findByFanAdminIsNotNull();

    List<UsedProp> findByActiveUntilGreaterThanAndStatusEqualsAndAcceptedBidNull(java.util.Date date, UsedPropStatus usedPropStatus);

    List<UsedProp> findByActiveUntilGreaterThanAndAcceptedBidNullAndStatusNot(java.util.Date date, UsedPropStatus usedPropStatus);

    List<UsedProp> findByUser(User user);

    UsedProp findOne(Long id);

    UsedProp save(UsedProp usedProp);

    void delete(Long id);
}
