package it.silph.silphportal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titolo;

    private String descrizione;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Foto> foto;

    @ManyToOne(cascade = CascadeType.ALL)
    private Fotografo fotografo;

    public Album() {

    }

    public Album(String titolo, String descrizione) {
	super();
	this.titolo = titolo;
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

    public List<Foto> getFoto() {
	return foto;
    }

    public void setFoto(List<Foto> foto) {
	this.foto = foto;
    }

    public Fotografo getFotografo() {
	return fotografo;
    }

    public void setFotografo(Fotografo fotografo) {
	this.fotografo = fotografo;
    }
    
    public Long getIdImmagineCopertina() {
	return this.foto.get(0).getIdImmagine();
    }
}
