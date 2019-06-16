package it.silph.silphportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funzionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String codice;
	
	private String password;
	
	private String role;
	
	public Funzionario() {
	}
	
	public Funzionario(String codice, String password) {
		this.codice = codice;
		this.password = password;
		this.role = "FUNZIONARIO";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
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
