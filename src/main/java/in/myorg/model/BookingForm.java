package in.myorg.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
@Table(name="BookingFormData")
@Entity
public class BookingForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "*Name can't be empty")
	@NotBlank(message = "*Name can't blank")
	private String name;

	@NotEmpty(message = "*Source can't be empty")
	@NotBlank(message = "*Source can't blank")
    private String source;

	
	
	@NotEmpty(message = "*Email can't be empty")
	@NotBlank(message = "*Name can't blank")
	private String email;

	@NotEmpty(message = "*Destination  can't be empty")
	@NotBlank(message = "*Destination can't blank")
	private String destination;
	
	
    @NotNull(message = "*Time can not be empty")
	private LocalTime time;
    @NotNull(message = "*Date can not be empty")
	private LocalDate date;
    
    
	@NotEmpty(message = "*Comfort  can't be empty")
	private String comfort;
	
	@Min(value=1 ,message = "*Adult must be atleast 1 ")
	@Max(value=4 ,message = "*Adult can be atmost 4 ")
	private Integer adult;
	
	@Max(value=3,message = "*Children canbe atmost 3 ")
	private Integer children;
	
	@NotEmpty(message = "*Message  can't be empty")
	@NotBlank(message = "* message can't be blank")
	private String message;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getComfort() {
		return comfort;
	}

	public void setComfort(String comfort) {
		this.comfort = comfort;
	}

	public Integer getAdult() {
		return adult;
	}

	public void setAdult(Integer adult) {
		this.adult = adult;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "BookingForm [id=" + id + ", name=" + name + ", from=" + source + ", email=" + email + ", to=" + destination
				+ ", time=" + time + ", date=" + date + ", comfort=" + comfort + ", adult=" + adult + ", children="
				+ children + ", message=" + message + "]";
	}

}
