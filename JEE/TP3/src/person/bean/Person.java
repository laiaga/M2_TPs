package person.bean;

public class Person {
	private int id;
	private String name;
	private String surname;
	private String birthdate;
	private String email;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public String getEmail() {
		return email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}