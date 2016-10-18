package model;

public class Person {
	int id;
	String name;
	String surname;
	String birthdate;
	String email;
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
