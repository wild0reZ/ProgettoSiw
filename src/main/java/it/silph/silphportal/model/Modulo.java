package it.silph.silphportal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Errato, il cascadeType non dovrebbe servire, ma ahime
    @ManyToMany(cascade = { CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH }, fetch = FetchType.EAGER)
    private List<Foto> foto;

    private String oggetto;

    private String messaggio;

    private String nomeCliente;

    private String cognomeCliente;

    private String indirizzo;

    private String email;

    private String telefono;

    private String citta;

    private String nazione;

    private String CAP;

    private String nomeAzienda;

    public Modulo() {
	this.foto = new ArrayList<>();
    }

    public Modulo(String oggetto, String messaggio, String nomeCliente, String cognomeCliente, String indirizzo,
	    String email, String telefono, String citta, String nazione, String CAP, String nomeAzienda) {
	this.oggetto = oggetto;
	this.messaggio = messaggio;
	this.nomeCliente = nomeCliente;
	this.cognomeCliente = cognomeCliente;
	this.indirizzo = indirizzo;
	this.email = email;
	this.telefono = telefono;
	this.citta = citta;
	this.nazione = nazione;
	this.CAP = CAP;
	this.nomeAzienda = nomeAzienda;
	this.foto = new ArrayList<>();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public List<Foto> getFoto() {
	return foto;
    }

    public void setFoto(List<Foto> foto) {
	this.foto = foto;
    }

    public String getOggetto() {
	return oggetto;
    }

    public void setOggetto(String oggetto) {
	this.oggetto = oggetto;
    }

    public String getMessaggio() {
	return messaggio;
    }

    public void setMessaggio(String messaggio) {
	this.messaggio = messaggio;
    }

    public String getNomeCliente() {
	return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
	this.nomeCliente = nomeCliente;
    }

    public String getCognomeCliente() {
	return cognomeCliente;
    }

    public void setCognomeCliente(String cognomeCliente) {
	this.cognomeCliente = cognomeCliente;
    }

    public String getIndirizzo() {
	return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
	this.indirizzo = indirizzo;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getTelefono() {
	return telefono;
    }

    public void setTelefono(String telefono) {
	this.telefono = telefono;
    }

    public String getCitta() {
	return citta;
    }

    public void setCitta(String citta) {
	this.citta = citta;
    }

    public String getNazione() {
	return nazione;
    }

    public void setNazione(String nazione) {
	this.nazione = nazione;
    }

    public String getCAP() {
	return CAP;
    }

    public void setCAP(String CAP) {
	this.CAP = CAP;
    }

    public String getNomeAzienda() {
	return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
	this.nomeAzienda = nomeAzienda;
    }

}
