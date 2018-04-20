package bookshow.domain.rating;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import bookshow.domain.Show;
import bookshow.domain.users.User;

@Embeddable
public class UserShow implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(optional = false)
	private User user;
	
	@ManyToOne(optional = false)
	private Show show;
	
	public UserShow(){
		
	}

	public UserShow(User user, Show show) {
		// TODO Auto-generated constructor stub
		this.user = user;
		this.show = show;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}
	
	

}
