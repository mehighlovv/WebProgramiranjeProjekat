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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import project.cinema.dto.CinemaDTO;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Cinema implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false)
	private String phone_number;
	
	@Column(nullable=false)
	private String email;
	@JsonIgnore
	@OneToMany(mappedBy="cinema",fetch=FetchType.EAGER,orphanRemoval = true)
	private Set<User> managers=new HashSet<>();
	
	@OneToMany(mappedBy="cinema",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Room> rooms=new HashSet<>();
	
	@OneToMany(mappedBy = "cinema", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Projection> schedule=new HashSet<>();
	
	public Set<Projection> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<Projection> schedule) {
		this.schedule = schedule;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<User> getManagers() {
		return managers;
	}

	public void setManagers(Set<User> managers) {
		this.managers = managers;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public Cinema(long id, String name, String address, String phone_number, String email, Set<User> managers,
			Set<Room> rooms, Set<Projection> schedule) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.email = email;
		this.managers = managers;
		this.rooms = rooms;
		this.schedule = schedule;
	}

	public Cinema() {
		
	}
	public static Cinema getCinemaByDTO(CinemaDTO cinemaDTO) {
		Cinema cinema=new Cinema();
		cinema.setAddress(cinemaDTO.getAddress());
		cinema.setEmail(cinemaDTO.getEmail());
		cinema.setName(cinemaDTO.getName());
		cinema.setPhone_number(cinemaDTO.getPhone_number());
		return cinema;
	}
}
