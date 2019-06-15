package it.silph.silphportal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Fotografo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String cognome;

    private String bio;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Immagine immagineProfilo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fotografo")
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

    public Immagine getImmagineProfilo() {
	return immagineProfilo;
    }

    public void setImmagineProfilo(Immagine immagineProfilo) {
	this.immagineProfilo = immagineProfilo;
    }

    public List<Album> getAlbum() {
	return album;
    }

    public void setAlbum(List<Album> album) {
	this.album = album;
    }

    public Long getIdImmagine() {
	return this.immagineProfilo.getId();
    }
    
    public void addAlbum(Album album) {
	this.album.add(album);
    }
    
    /**
     * Potenzialmente si dovrebbe fare per tutti gli oggetti
     */
    @Override
    public boolean equals(Object obj) {
	Fotografo f = (Fotografo) obj;
        return this.id == f.getId();
    }
}
