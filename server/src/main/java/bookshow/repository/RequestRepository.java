package bookshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshow.domain.users.Request;

public interface RequestRepository extends JpaRepository<Request, Long>{
	Request findByPoslao(String poslao);
	Request findByPrimio(String primio);
}
