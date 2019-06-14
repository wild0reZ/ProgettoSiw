package it.silph.silphportal.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funzionario {

	@Id
	private long id;
	
	private String password;
	
	private String role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
