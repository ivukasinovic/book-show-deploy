package bookshow.domain.movie;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import bookshow.domain.users.User;

@Entity
public class Purchase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(optional = false)
	private User user;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	public Purchase(){
		
	}

	public Purchase(User user, Date date) {
		this.user = user;
		this.date = date;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
