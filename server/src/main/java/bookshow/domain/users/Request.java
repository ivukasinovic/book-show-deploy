package bookshow.domain.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Request implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;
	
	public Long getId() {
		return id;
	}


	@Column(nullable = false, unique = false)
    private String poslao;
	
	@Column(nullable = false, unique = false)
    private String primio;

	public String getPoslao() {
		return poslao;
	}

	public void setPoslao(String poslao) {
		this.poslao = poslao;
	}

	public String getPrimio() {
		return primio;
	}

	public void setPrimio(String primio) {
		this.primio = primio;
	}
	
	
}
