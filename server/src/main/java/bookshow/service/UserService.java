package bookshow.service;

import bookshow.domain.users.User;

import java.util.List;

/**
 * Created by Ivan V.
 */
public interface UserService {
    List<User> findAll();

    User findOne(Long id);

    User findByUsername(String username);
    
    User findByEmail(String email);

    User save(User user);

    void delete(Long id);


}
