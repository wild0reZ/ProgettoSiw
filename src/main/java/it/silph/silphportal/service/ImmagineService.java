package it.silph.silphportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.silph.silphportal.model.Immagine;
import it.silph.silphportal.repository.ImmagineRepository;

@Service
public class ImmagineService {
    
    @Autowired
    private ImmagineRepository immagineRepository;

    @Transactional
    public Immagine immaginePerId(Long id) {
	return this.immagineRepository.findById(id).get();
    }
}
