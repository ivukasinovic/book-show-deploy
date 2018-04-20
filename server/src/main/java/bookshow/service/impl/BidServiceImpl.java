package bookshow.service.impl;

import bookshow.domain.Bid;
import bookshow.domain.props.UsedProp;
import bookshow.domain.props.UsedPropStatus;
import bookshow.domain.users.User;
import bookshow.repository.BidRepository;
import bookshow.service.BidService;
import bookshow.service.UsedPropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@Service
public class BidServiceImpl implements BidService {
    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private UsedPropService usedPropService;

    @Override
    public List<Bid> findAll() {
        return bidRepository.findAll();
    }

    @Override
    public List<Bid> findByUsedPropOrderByPriceDesc(UsedProp usedProp) {
        return bidRepository.findByUsedPropOrderByPriceDesc(usedProp);
    }

    @Override
    public List<Bid> findByUsedProp(UsedProp usedProp) {
        return bidRepository.findByUsedProp(usedProp);
    }

    @Override
    public Bid findByUserAndUsedProp(User user, UsedProp usedProp) {
        return bidRepository.findByUserAndUsedProp(user, usedProp);
    }

    @Override
    public Bid findOne(Long id) {
        return bidRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.SUPPORTS)
    public Bid save(Bid bid) {
        return bidRepository.save(bid);
    }

    @Override
    public Bid findByPrice(Integer price) {
        return bidRepository.findByPrice(price);
    }

    @Override
    public Bid findByUser(User user) {
        return bidRepository.findByUser(user);
    }

    @Override
    public void delete(Long id) {
        bidRepository.delete(id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Bid createEditBid(UsedProp usedProp,Bid bid, User registeredUser){
        usedProp.setAccesstime(usedProp.getAccesstime()+1);
        usedPropService.save(usedProp);
        System.out.println("sacuvao kreta imam:" + usedProp.getVersion() + "a u bazi je :") ;
        if (usedProp.getUser() == registeredUser) {
            return null;
        }
        if(usedProp.getAcceptedBid() != null){
            return null;
        }
        Bid old = findByUserAndUsedProp(registeredUser, usedProp);
        if (old != null) {
            old.setPrice(bid.getPrice());
            bid = old;
        }else{
            bid.setDateCreated(new java.util.Date());
            bid.setUser(registeredUser);
            bid.setUsedProp(usedProp);
        }
       // usedPropService.save(usedProp);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return save(bid);
    }
}
