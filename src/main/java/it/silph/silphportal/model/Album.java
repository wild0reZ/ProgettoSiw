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
import javax.persistence.OneToOne;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titolo;

    private String descrizione;

    // Cambiando il FetchType a EAGER funziona, ma le query
    // limitate creano un sacco di problemi (ad esempio, riempie
    // gli spazi vuoti con duplicati).
    // Sconfiggere la "LazyInitializationException"
    @OneToMany(cascade = CascadeType.ALL)
    private List<Foto> foto;

    @ManyToOne
    private Fotografo fotografo;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Immagine immagineCopertina;

    public Album() {

    }

    /**
     * Costruttore generico per testing
     * @param titolo
     * @param descrizione
     */
    public Album(String titolo, String descrizione) {
	super();
	this.titolo = titolo;
	this.descrizione = descrizione;
	this.foto = new ArrayList<>();
    }
    
    /**
     * Costruttore per la creazione di un nuovo album come operazione di sistema
     * @param titolo
     * @param descrizione
     * @param foto
     */
    public Album(String titolo, String descrizione, Foto foto) {
	this(titolo, descrizione);
	this.foto.add(foto);
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

    public Immagine getImmagineCopertina() {
        return immagineCopertina;
    }

    public void setImmagineCopertina(Immagine immagineCopertina) {
        this.immagineCopertina = immagineCopertina;
    }

    /**
     * Operazione di sistema!
     * @param foto
     */
    public void addFoto(Foto foto) {
	this.foto.add(foto);
	this.immagineCopertina = foto.getImmagine();
    }

    @Override
    public boolean equals(Object obj) {
	Album a = (Album) obj;
        return this.id == a.getId();
    }

}
