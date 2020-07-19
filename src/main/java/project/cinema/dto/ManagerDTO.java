package project.cinema.dto;

import java.sql.Date;

import project.cinema.model.Roles;

public class ManagerDTO {
	private Long cinema_id;
	private String name;
	private String lastname;
	private String email;
	private String password;
	private String username;
	private String phone_number;
	private Date date;
	private Roles role;
	private boolean activity;
	public Long getCinema_id() {
		return cinema_id;
	}
	public void setCinema_id(long cinema_id) {
		this.cinema_id = cinema_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	public boolean isActivity() {
		return activity;
	}
	public void setActivity(boolean activity) {
		this.activity = activity;
	}
	public ManagerDTO() {}
	
}
