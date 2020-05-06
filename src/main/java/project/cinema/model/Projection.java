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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Projection implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private weekDays day;
	
	@Column
	private long price;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Movie movie;
	
	@ManyToMany(mappedBy="projections")
	private Set<Room> rooms=new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Cinema cinema;
	
	@ManyToMany(mappedBy="reserved_tickets")
	private Set<Viewer> viewers=new HashSet<>();

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Set<Viewer> getViewers() {
		return viewers;
	}

	public void setViewers(Set<Viewer> viewers) {
		this.viewers = viewers;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public weekDays getDay() {
		return day;
	}

	public void setDay(weekDays day) {
		this.day = day;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public Projection(long id, weekDays day, long price, Movie movie, Set<Room> rooms, Cinema cinema,
			Set<Viewer> viewers) {
		super();
		this.id = id;
		this.day = day;
		this.price = price;
		this.movie = movie;
		this.rooms = rooms;
		this.cinema = cinema;
		this.viewers = viewers;
	}
	
	
}
enum weekDays{MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY};