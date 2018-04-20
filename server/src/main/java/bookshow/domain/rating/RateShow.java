package bookshow.domain.rating;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import bookshow.domain.Show;
import bookshow.domain.users.User;


@Entity
public class RateShow implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
	private UserShow userShow;
	
	@Column(nullable = false)
	@Min(1)
	@Max(5)
	private double rating;
	
	public RateShow(){
		
	}

	public UserShow getUserShow() {
		return userShow;
	}

	public void setUserShow(UserShow userShow) {
		this.userShow = userShow;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	
	
}
