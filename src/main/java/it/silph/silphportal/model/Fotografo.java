package it.silph.silphportal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Fotografo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String cognome;

    private String bio;

    @Lob
    private byte[] immagineProfilo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Album> album;

    public Fotografo() {
	
    }

    public Fotografo(String nome, String cognome, String bio) {
	super();
	this.nome = nome;
	this.cognome = cognome;
	this.bio = bio;
	this.album = new ArrayList<>();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getCognome() {
	return cognome;
    }

    public void setCognome(String cognome) {
	this.cognome = cognome;
    }

    public String getBio() {
	return bio;
    }

    public void setBio(String bio) {
	this.bio = bio;
    }

    public byte[] getImmagineProfilo() {
	return immagineProfilo;
    }

    public void setImmagineProfilo(byte[] immagineProfilo) {
	this.immagineProfilo = immagineProfilo;
    }

    public List<Album> getAlbum() {
	return album;
    }

    public void setAlbum(List<Album> album) {
	this.album = album;
    }

}
