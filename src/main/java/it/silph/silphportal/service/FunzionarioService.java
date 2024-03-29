package it.silph.silphportal.service;

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
	public Funzionario inserisci(Funzionario funzionario) {
		return this.funzionarioRepository.save(funzionario);
	}

	
}
