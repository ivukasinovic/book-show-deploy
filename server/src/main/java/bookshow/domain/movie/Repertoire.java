package bookshow.domain.movie;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Repertoire implements Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DateShow dateShow;
	
	public Repertoire(){
		
	}

	public DateShow getDateShow() {
		return dateShow;
	}

	public void setDateShow(DateShow dateShow) {
		this.dateShow = dateShow;
	}
	
	
	
}
