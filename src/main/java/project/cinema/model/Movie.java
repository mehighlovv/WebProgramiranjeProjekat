package project.cinema.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Movie implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column
	private String description;
		
	@Column(nullable=false)
	private String genre;
	
	@Column(nullable=false)
	private long duration;// u minutima
	
	@Column 
	private double rating;
	
	@OneToMany(mappedBy="movie",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Watched_movie> watched_movies=new HashSet<>();
	
	@OneToMany(mappedBy="movie",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Projection> projections=new HashSet<>();
	
	public Set<Watched_movie> getWatched_movies() {
		return watched_movies;
	}

	public void setWatched_movies(Set<Watched_movie> watched_movies) {
		this.watched_movies = watched_movies;
	}

	public Set<Projection> getProjections() {
		return projections;
	}

	public void setProjections(Set<Projection> projections) {
		this.projections = projections;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Movie(long id, String name, String description, String genre, long duration, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
	}
	
	public Movie() {
		rating=0;
	}
	
}
