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

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titoloAlbum;

    private String descrizione;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private List<Foto> foto;

    @ManyToOne//(fetch = FetchType.EAGER)
    private Fotografo fotografo;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Immagine immagineCopertina;

    public Album() {
	this.foto = new ArrayList<>();
    }

    /**
     * Costruttore generico per testing
     * @param titolo
     * @param descrizione
     */
    public Album(String titoloAlbum, String descrizione) {
	super();
	this.titoloAlbum = titoloAlbum;
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

    public String getTitoloAlbum() {
	return titoloAlbum;
    }

    public void setTitoloAlbum(String titoloAlbum) {
	this.titoloAlbum = titoloAlbum;
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
	foto.setAlbum(this);
	this.immagineCopertina = foto.getImmagine();
    }

    @Override
    public boolean equals(Object obj) {
	Album a = (Album) obj;
        return this.id == a.getId();
    }

    public void addToFotografo(Fotografo fotografo) {
	this.fotografo = fotografo;
	fotografo.getAlbum().add(this);
    }

}
