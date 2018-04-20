package bookshow.domain.movie;


import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Size;

import bookshow.domain.Show;


@Entity
@Table(name = "playfilm_ct")
public class PlayFilm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false)
	@Size(min=3, max=35)
	private String name;
	
	@Column(nullable = false)
	private String actors;
	
	@Column(nullable = false)
	private String genre;
	
	@Column
	private String director;
	
	@Column(nullable = false)
	private String duration;
	
	@Column
	private String imageUrl;
	
	@Column
	private double averageScore;
	
	@Column
	private String description;
	
	@ManyToOne(optional = false)
	private Show show;
	
	public PlayFilm(){
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public Show getShow() {
		return show;
	}


	public void setShow(Show show) {
		this.show = show;
	}

	
	
	
}
