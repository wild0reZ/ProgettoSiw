package it.silph.silphportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.silph.silphportal.model.Modulo;
import it.silph.silphportal.repository.ModuloRepository;

@Service
public class ModuloService {
    @Autowired
    private ModuloRepository moduloRepository;

    @Transactional
    public void inserisci(Modulo modulo) {
	this.moduloRepository.save(modulo);
    }
}
