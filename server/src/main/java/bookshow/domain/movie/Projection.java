package bookshow.domain.movie;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Min;

import bookshow.domain.Auditorium;

@Entity
public class Projection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false)
	private String time;
	
	@ManyToOne(optional = false)
	private Auditorium auditorium;
	
	@ManyToOne(optional = false)
	private PlayFilm playfilm;
	
	@ManyToOne(optional = false)
	private Repertoire repertoire;
	
	@Column(nullable = false)
	@Min(0)
	private double price;
	
	public Projection(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}

	public PlayFilm getPlayfilm() {
		return playfilm;
	}

	public void setPlayfilm(PlayFilm playfilm) {
		this.playfilm = playfilm;
	}

	public Repertoire getRepertoire() {
		return repertoire;
	}

	public void setRepertoire(Repertoire repertoire) {
		this.repertoire = repertoire;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
