package bookshow.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bookshow.domain.users.Request;
import bookshow.repository.RequestRepository;
import bookshow.service.RequestService;


@Service
public class RequestServiceImpl implements RequestService{

	@Autowired
	private RequestRepository RequestRepository;

	@Override
	public Request save(Request request) {
		return RequestRepository.save(request);
	}


	

	@Override
	public List<Request> fintAll() {
		return RequestRepository.findAll();
	}


	@Override
	public void delete(Long id) {
		RequestRepository.delete(id);
		
	}

	@Override
	public Request findByPoslao(String poslao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Request findByPrimio(String primio) {
		// TODO Auto-generated method stub
		return null;
	}




}
