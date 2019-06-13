package it.silph.silphportal.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;



@Entity
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titolo;
    private String Descrizione;
    @OneToMany
    private List<Tag> tags;
    private LocalDate dataInserimento;
    
    // private String percorsoImmagine;
    // AntiPattern, salva in file separato
    @Lob
    private byte[] immagine;

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
	return Descrizione;
    }

    public void setDescrizione(String descrizione) {
	Descrizione = descrizione;
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
