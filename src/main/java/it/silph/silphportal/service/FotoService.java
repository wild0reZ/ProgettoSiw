package it.silph.silphportal.service;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.silph.silphportal.model.Album;
import it.silph.silphportal.model.Foto;
import it.silph.silphportal.repository.FotoRepository;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    @Transactional
    public Foto fotoPerId(Long id) {
	return fotoRepository.findById(id).get();
    }

    @Transactional
    public List<Foto> tutte() {
	return fotoRepository.findAll();
    }

    @Transactional
    public List<Foto> tuttePerData() {
	return fotoRepository.findAllByOrderByDataInserimento();
    }

    @Transactional
    public List<Foto> prime9PerData() {
	return fotoRepository.findFirst9ByOrderByDataInserimento();
    }

    @Transactional
    public List<Foto> tuttePerAlbum(Album a) {
	return this.fotoRepository.findAllByAlbum(a);
    }

    public Page<Foto> findPaginated(Pageable pageable, List<Foto> gruppoFoto) {
	int pageSize = pageable.getPageSize();
	int currentPage = pageable.getPageNumber();
	int startItem = currentPage * pageSize;
	List<Foto> list;

	if (gruppoFoto.size() < startItem) {
	    list = Collections.emptyList();
	} else {
	    int toIndex = Math.min(startItem + pageSize, gruppoFoto.size());
	    list = gruppoFoto.subList(startItem, toIndex);
	}

	Page<Foto> fotoPage = new PageImpl<Foto>(list, PageRequest.of(currentPage, pageSize), gruppoFoto.size());

	return fotoPage;
    }
}