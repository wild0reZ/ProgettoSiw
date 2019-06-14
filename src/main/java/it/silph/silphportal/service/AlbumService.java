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

import it.silph.silphportal.model.Album;
import it.silph.silphportal.repository.AlbumRepository;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Transactional
    public Album fotoPerId(Long id) {
	return albumRepository.findById(id).get();
    }

    @Transactional
    public List<Album> tutte() {
	return albumRepository.findAll();
    }

    @Transactional
    public List<Album> tuttePerData() {
	return albumRepository.findAllByOrderByFoto_DataInserimento();
    }

    @Transactional
    public List<Album> primi10PerData() {
	return albumRepository.findFirst10ByOrderByFoto_DataInserimento();
    }

    public Page<Album> findPaginated(Pageable pageable, List<Album> gruppoAlbum) {
	int pageSize = pageable.getPageSize();
	int currentPage = pageable.getPageNumber();
	int startItem = currentPage * pageSize;
	List<Album> list;

	if (gruppoAlbum.size() < startItem) {
	    list = Collections.emptyList();
	} else {
	    int toIndex = Math.min(startItem + pageSize, gruppoAlbum.size());
	    list = gruppoAlbum.subList(startItem, toIndex);
	}

	Page<Album> albumPage = new PageImpl<Album>(list, PageRequest.of(currentPage, pageSize), gruppoAlbum.size());

	return albumPage;
    }

}
