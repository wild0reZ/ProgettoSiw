package it.silph.silphportal.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titolo;

    private String descrizione;
    
    private LocalDate dataInserimento;

    @OneToOne(cascade = CascadeType.ALL)
    private Immagine immagine;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Fotografo fotografo;
    
    public Foto() {

    }

    public Foto(String titolo, String descrizione, LocalDate dataInserimento, Immagine immagine) {
	super();
	this.titolo = titolo;
	this.descrizione = descrizione;
	this.dataInserimento = dataInserimento;
	this.immagine = immagine;
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

    public Long getIdImmagine() {
	return this.immagine.getId();
    }

    public Fotografo getFotografo() {
	return this.fotografo;
    }

    public void setFotografo(Fotografo fotografo) {
	this.fotografo = fotografo;
    }
}
