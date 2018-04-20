package bookshow.service.impl;

import bookshow.domain.props.NewProp;
import bookshow.domain.users.User;
import bookshow.repository.NewPropRepository;
import bookshow.service.NewPropService;
import bookshow.service.UserService;
import groovy.transform.TailRecursive;
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
@Transactional(readOnly = true)
public class NewPropServiceImpl implements NewPropService {
    @Autowired
    private NewPropRepository newPropRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<NewProp> findAll() {
        return newPropRepository.findAll();
    }

    @Override
    public List<NewProp> findByUserIsNull() {
        return newPropRepository.findByUserIsNull();
    }

    @Override
    public List<NewProp> findByUser(User user) {
        return newPropRepository.findByUser(user);
    }

    @Override
    public NewProp findOne(Long id) {
        return newPropRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    public NewProp save(NewProp newProp) {
        return newPropRepository.save(newProp);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        newPropRepository.delete(id);
    }

    //Thread.sleep omogucava simulaciju izvrsavanja transakcije
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public NewProp reserve(NewProp newProp, String username) {
        if (newProp.getUser() != null) {
            return null;
        }
        User user = userService.findByUsername(username);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        user.setPoints(user.getPoints() + 1L);
        userService.save(user);
        newProp.setUser(user);
        return save(newProp);
    }


}
