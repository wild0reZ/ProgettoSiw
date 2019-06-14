package it.silph.silphportal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titolo;

    private String descrizione;

    @OneToMany
    private List<Foto> foto;

    public Album(String titolo, String descrizione) {
	super();
	this.descrizione = descrizione;
	this.foto = new ArrayList<>();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getTitolo() {
	return titolo;
    }

    public void setTitolo(String titolo) {
	this.titolo = titolo;
    }

    public String getDescrizione() {
	return descrizione;
    }

    public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
    }

    public Foto getFoto() {
	return foto;
    }

    public void setFoto(Foto foto) {
	this.foto = foto;
    }
}
