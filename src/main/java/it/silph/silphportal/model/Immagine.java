package it.silph.silphportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Immagine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Lob
    private byte[] fileImmagine;
    
    public Immagine() {
	
    }

    public Immagine(byte[] fileImmagine) {
	this.fileImmagine = fileImmagine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFileImmagine() {
        return fileImmagine;
    }

    public void setFileImmagine(byte[] immagine) {
        this.fileImmagine = immagine;
    }
    
    @Override
    public boolean equals(Object obj) {
	Immagine i = (Immagine) obj;
        return this.id == i.getId();
    }

}
