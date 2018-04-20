package bookshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.users.Friendship;

/**
 * 
 * @author Vladimir
 *
 */
public interface FriendshipRepository extends JpaRepository<Friendship, Long>{}
