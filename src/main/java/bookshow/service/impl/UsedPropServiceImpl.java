package bookshow.service.impl;

import bookshow.domain.Bid;
import bookshow.domain.props.UsedProp;
import bookshow.domain.props.UsedPropStatus;
import bookshow.domain.users.Role;
import bookshow.domain.users.User;
import bookshow.repository.UsedPropRepository;
import bookshow.service.BidService;
import bookshow.service.UsedPropService;
import bookshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@Service
@Transactional(readOnly = true)
public class UsedPropServiceImpl implements UsedPropService {
    @Autowired
    private UsedPropRepository usedPropRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private BidService bidService;

    @Override
    public List<UsedProp> findAll() {
        return usedPropRepository.findAll();
    }

    @Override
    public UsedProp findOne(Long id) {
        return usedPropRepository.findOne(id);
    }

    @Override
    public List<UsedProp> findByFanAdminIsNotNull() {
        return usedPropRepository.findByFanAdminIsNotNull();
    }

    @Override
    public List<UsedProp> findByActiveUntilGreaterThanAndStatusEqualsAndAcceptedBidNull(Date date, UsedPropStatus usedPropStatus) {
        return usedPropRepository.findByActiveUntilGreaterThanAndStatusEqualsAndAcceptedBidNull(date, usedPropStatus);
    }

    @Override
    public List<UsedProp> findByActiveUntilGreaterThanAndAcceptedBidNullAndStatusNot(Date date, UsedPropStatus usedPropStatus) {
        return usedPropRepository.findByActiveUntilGreaterThanAndAcceptedBidNullAndStatusNot(date, usedPropStatus);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    public UsedProp save(UsedProp usedProp) {
        return usedPropRepository.save(usedProp);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        usedPropRepository.delete(id);
    }

    @Override
    public List<UsedProp> findByUsername(String username) {
        User user = userService.findByUsername(username);
        return usedPropRepository.findByUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public UsedProp createUsedProp(String username, UsedProp usedProp) {
        User user = userService.findByUsername(username);
        if (user.getRole() == Role.ADMINFAN) {
            usedProp.setStatus(UsedPropStatus.APPROVED);
            usedProp.setFanAdmin(user);
        } else {
            usedProp.setStatus(UsedPropStatus.WAITING);
        }
        usedProp.setUser(userService.findByUsername(username));
        usedProp.setDateCreated(new java.util.Date());
        usedProp.setBids(new ArrayList<Bid>());
        return save(usedProp);
    }
    //Thread.sleep omogucava simulaciju izvrsavanja transakcije
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public UsedProp approveDecline(UsedProp usedProp, String type, User adminFan) {
        if ((usedProp.getStatus().equals(UsedPropStatus.APPROVED) || (usedProp.getStatus().equals(UsedPropStatus.DECLINED)))) {
            return null;
        }
        if (type.equals("approve")) {
            usedProp.setStatus(UsedPropStatus.APPROVED);
        } else if (type.equals("decline")) {
            usedProp.setStatus(UsedPropStatus.DECLINED);
        } else {
            return null;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        usedProp.setFanAdmin(adminFan);
        UsedProp savedUsedProp = save(usedProp);
        return savedUsedProp;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public UsedProp acceptBid(String username, UsedProp usedProp, Long acceptedBidId) {
        User user = userService.findByUsername(username);
        if (usedProp.getAcceptedBid() != null) {
            return null;
        }
        if (!usedProp.getUser().getUsername().equals(user.getUsername())) {
            return null;
        }
        Bid bid = bidService.findOne(acceptedBidId);
        bid.setAccepted(true);

        usedProp.setAcceptedBid(bid.getId());
        usedProp = save(usedProp);
        usedProp.setStatus(UsedPropStatus.FINISHED);
        System.out.println("sacuvao Accept");
        bidService.save(bid);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return usedProp;
    }


}
