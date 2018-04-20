package bookshow.domain.movie;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import bookshow.domain.Seat;

@Entity
public class Ticket implements Serializable{
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 
	 @ManyToOne(optional = false)
	 private Projection projection;
	 
	 //inicijalno je 0
	 @Column(nullable = false)
	 private double discount;
	 
	 @OneToOne(optional = false)
	 private Seat seat;
	 
	 @OneToOne
	 private Purchase purchased;
	 
	 public Ticket(){
		 
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Purchase getPurchased() {
		return purchased;
	}

	public void setPurchased(Purchase purchased) {
		this.purchased = purchased;
	}

	 
	
	 
}
