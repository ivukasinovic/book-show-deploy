package bookshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshow.domain.users.Friendship;
import bookshow.repository.FriendshipRepository;
import bookshow.service.FriendshipService;

@Service
public class FriendshipServiceImpl implements FriendshipService{

	@Autowired 
	private FriendshipRepository FriendshipRepository;
	
	@Override
	public List<Friendship> findAll() {
		return FriendshipRepository.findAll();
	}

	@Override
	public Friendship save(Friendship friendship) {
		return FriendshipRepository.save(friendship);
	}

	@Override
	public void delete(Long Id) {
		FriendshipRepository.delete(Id);
		
	}

}
