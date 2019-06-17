package it.silph.silphportal.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.silph.silphportal.model.Foto;
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

    @Transactional
    public void newModuloById(Modulo modulo, Long id) {
	Modulo fetch = this.moduloRepository.findById(id).get();
	modulo.setCAP(fetch.getCAP());
	modulo.setCitta(fetch.getCitta());
	modulo.setCognomeCliente(fetch.getCognomeCliente());
	modulo.setEmail(fetch.getEmail());
	modulo.setFoto(fetch.getFoto());
	modulo.setId(fetch.getId());
	modulo.setIndirizzo(fetch.getIndirizzo());
	modulo.setMessaggio(fetch.getMessaggio());
	modulo.setNazione(fetch.getNazione());
	modulo.setNomeAzienda(fetch.getNomeAzienda());
	modulo.setNomeCliente(fetch.getNomeCliente());
	modulo.setOggetto(fetch.getOggetto());
	modulo.setTelefono(fetch.getTelefono());
    }

    @Transactional
    public List<Modulo> tutti() {
	return this.moduloRepository.findAll();
    }

    public Page<Modulo> findPaginated(Pageable pageable, List<Modulo> gruppoModulo) {
	int pageSize = pageable.getPageSize();
	int currentPage = pageable.getPageNumber();
	int startItem = currentPage * pageSize;
	List<Modulo> list;

	if (gruppoModulo.size() < startItem) {
	    list = Collections.emptyList();
	} else {
	    int toIndex = Math.min(startItem + pageSize, gruppoModulo.size());
	    list = gruppoModulo.subList(startItem, toIndex);
	}

	Page<Modulo> moduloPage = new PageImpl<Modulo>(list, PageRequest.of(currentPage, pageSize),
		gruppoModulo.size());

	return moduloPage;
    }

    @Transactional
    public Modulo moduloPerId(Long id) {
	return this.moduloRepository.getOne(id);
    }

    @Transactional
    public List<Foto> fotoModulo(Long id) {
	return this.moduloRepository.getOne(id).getFoto();
    }
}
