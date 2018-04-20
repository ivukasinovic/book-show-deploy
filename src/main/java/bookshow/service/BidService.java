package bookshow.service;

import bookshow.domain.Bid;
import bookshow.domain.props.UsedProp;
import bookshow.domain.users.User;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface BidService {
    List<Bid> findAll();

    List<Bid> findByUsedPropOrderByPriceDesc(UsedProp usedProp);

    List<Bid> findByUsedProp(UsedProp usedProp);

    Bid findByUserAndUsedProp(User user, UsedProp usedProp);

    Bid findOne(Long id);

    Bid save(Bid bid);

    Bid findByPrice(Integer price);

    Bid findByUser(User user);

    void delete(Long id);

    Bid createEditBid(UsedProp usedProp,Bid bid, User registeredUser);
}
