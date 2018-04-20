package bookshow.service;

import java.util.List;

import bookshow.domain.users.Friendship;

public interface FriendshipService {
	List<Friendship> findAll();
	public Friendship save(Friendship friendship);
	public void delete(Long Id);
}
