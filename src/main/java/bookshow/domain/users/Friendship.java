package bookshow.domain.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friendship {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;
	
	public Long getId() {
		return id;
	}

	@Column(nullable = false, unique = false)
    private String prijatelj1;
	
	@Column(nullable = false, unique = false)
    private String prijatelj2;

	public Friendship(){}
	
	public Friendship(String prijatelj1, String prijatelj2) {
		this.prijatelj1 = prijatelj1;
		this.prijatelj2 = prijatelj2;
	}

	public String getPrijatelj1() {
		return prijatelj1;
	}

	public void setPrijatelj1(String prijatelj1) {
		this.prijatelj1 = prijatelj1;
	}

	public String getPrijatelj2() {
		return prijatelj2;
	}

	public void setPrijatelj2(String prijatelj2) {
		this.prijatelj2 = prijatelj2;
	}

	
	
}
