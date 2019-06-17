package it.silph.silphportal.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titoloFoto;

    private LocalDate dataInserimento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Immagine immagine;

    @OneToOne
    private Fotografo fotografo;

    @ManyToOne
    private Album album;

    public Foto() {
	this.dataInserimento = LocalDate.now();
    }
    
    public Foto(String titolo, Immagine immagine, Fotografo fotografo, Album album) {
	
    }

    public Foto(String titolo, LocalDate dataInserimento, Immagine immagine) {
	super();
	this.titoloFoto = titolo;
	this.dataInserimento = dataInserimento;
	this.immagine = immagine;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getTitoloFoto() {
	return titoloFoto;
    }

    public void setTitoloFoto(String titoloFoto) {
	this.titoloFoto = titoloFoto;
    }

    public LocalDate getDataInserimento() {
	return dataInserimento;
    }

    public void setDataInserimento(LocalDate dataInserimento) {
	this.dataInserimento = dataInserimento;
    }

    public Immagine getImmagine() {
	return immagine;
    }

    public void setImmagine(Immagine immagine) {
	this.immagine = immagine;
    }

    public Fotografo getFotografo() {
	return this.fotografo;
    }

    public void setFotografo(Fotografo fotografo) {
	this.fotografo = fotografo;
    }

    public Album getAlbum() {
	return album;
    }

    public void setAlbum(Album album) {
	this.album = album;
    }

    @Override
    public boolean equals(Object obj) {
	Foto f = (Foto) obj;
	return this.id == f.getId();
    }

}
