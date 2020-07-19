package project.cinema.dto;

public class RoomDTO {
	private Long cinema_id;
	private Long capacity;
	private String mark;
	public Long getCinema_id() {
		return cinema_id;
	}
	public void setCinema_id(Long cinema_id) {
		this.cinema_id = cinema_id;
	}
	public Long getCapacity() {
		return capacity;
	}
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public RoomDTO() {
		
	}
	
}
