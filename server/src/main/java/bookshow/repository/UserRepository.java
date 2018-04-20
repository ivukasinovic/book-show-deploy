package bookshow.repository;

import bookshow.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ivan V.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
