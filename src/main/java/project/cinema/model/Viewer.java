package project.cinema.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Viewer extends User {
	@OneToMany(mappedBy="viewer",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	Set<Watched_movie> watched_movies=new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "RESERVATIONS",
    joinColumns = @JoinColumn(name = "viewer_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "projection_id", referencedColumnName = "id"))
	Set<Projection> reserved_tickets=new HashSet<>();

	public Set<Watched_movie> getWatched_movies() {
		return watched_movies;
	}

	public void setWatched_movies(Set<Watched_movie> watched_movies) {
		this.watched_movies = watched_movies;
	}

	public Set<Projection> getReserved_tickets() {
		return reserved_tickets;
	}

	public void setReserved_tickets(Set<Projection> reserved_tickets) {
		this.reserved_tickets = reserved_tickets;
	}

	public Viewer(long id, String username, String password, String name, String lastname, String phone_number,
			String email, Date date, boolean activity, Cinema cinema,Set<Watched_movie> watched_movies, Set<Projection> reserved_tickets) {
		super(id,username,password,name,lastname,phone_number,email,date,Roles.VIEWER,activity,cinema);
		this.watched_movies = watched_movies;
		this.reserved_tickets = reserved_tickets;
	}
	public Viewer()
	{}
}
