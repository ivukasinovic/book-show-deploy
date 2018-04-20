package bookshow.repository;

import bookshow.domain.Bid;
import bookshow.domain.props.UsedProp;
import bookshow.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findAll();

    List<Bid> findByUsedPropOrderByPriceDesc(UsedProp usedProp);
    List<Bid> findByUsedProp(UsedProp usedProp);

    Bid findByUserAndUsedProp(User user, UsedProp usedProp);

    Bid findOne(Long id);

    Bid save(Bid bid);

    Bid findByPrice(Integer price);

    Bid findByUser(User user);

    void delete(Long id);

}
