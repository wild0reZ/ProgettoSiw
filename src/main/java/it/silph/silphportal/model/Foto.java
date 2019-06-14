package it.silph.silphportal.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titolo;

    private String descrizione;

    private LocalDate dataInserimento;

    @Lob
    private byte[] immagine;

    public Foto() {

    }

    public Foto(String titolo, String descrizione, LocalDate dataInserimento, byte[] immagine) {
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

    public byte[] getImmagine() {
	return immagine;
    }

    public void setImmagine(byte[] immagine) {
	this.immagine = immagine;
    }

}
