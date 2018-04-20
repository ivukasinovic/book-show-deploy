package bookshow.service;

import java.util.List;

import bookshow.domain.users.Request;


public interface RequestService {
	Request findByPoslao(String poslao);	
	Request findByPrimio(String primio);
	Request save(Request request);
	List<Request> fintAll();
	void delete(Long id);
}
