package bookshow.service;

import bookshow.domain.props.UsedProp;
import bookshow.domain.props.UsedPropStatus;
import bookshow.domain.users.User;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface UsedPropService {
    List<UsedProp> findAll();

    UsedProp findOne(Long id);

    List<UsedProp> findByFanAdminIsNotNull();

    List<UsedProp> findByActiveUntilGreaterThanAndStatusEqualsAndAcceptedBidNull(java.util.Date date, UsedPropStatus usedPropStatus);

    List<UsedProp> findByActiveUntilGreaterThanAndAcceptedBidNullAndStatusNot(java.util.Date date, UsedPropStatus usedPropStatus);

    UsedProp save(UsedProp usedProp);

    void delete(Long id);

    List<UsedProp> findByUsername(String username);

    UsedProp createUsedProp(String username, UsedProp usedProp);

    UsedProp approveDecline(UsedProp usedProp, String type, User adminFan);

    UsedProp acceptBid(String username, UsedProp usedProp, Long acceptedBidId);
}
