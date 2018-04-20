package bookshow.domain.movie;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import bookshow.domain.Show;

@Embeddable
public class DateShow implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne(optional = false)
	private Show show;
	
	public DateShow(){
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}
	
	
}
