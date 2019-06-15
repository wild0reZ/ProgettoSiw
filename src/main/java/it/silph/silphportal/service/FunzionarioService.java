package it.silph.silphportal.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.silph.silphportal.model.Funzionario;
import it.silph.silphportal.repository.FunzionarioRepository;

@Service
public class FunzionarioService {
	
	@Autowired
	FunzionarioRepository funzionarioRepository;
	
	@Transactional
	public Funzionario findByCodice(String codice) {	
		return this.funzionarioRepository.findByCodice(codice);
	}
	
	@Transactional
	public List<Funzionario> tutti() {
		return (List<Funzionario>) this.funzionarioRepository.findAll();
	}
	
}
