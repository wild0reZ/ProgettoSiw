package it.silph.silphportal.service;

import java.util.ArrayList;
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
import it.silph.silphportal.model.Fotografo;
import it.silph.silphportal.repository.AlbumRepository;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Transactional
    public Album albumPerId(Long id) {
	return this.albumRepository.findById(id).get();
    }

    @Transactional
    public List<Album> tutti() {
	return this.albumRepository.findAll();
    }

    @Transactional
    public List<Album> tuttiPerData() {
	return this.albumRepository.customFindAllByFotoDataInserimento();
    }

    @Transactional
    public List<Album> tuttiPerFotografo(Fotografo fotografo) {
	return this.albumRepository.findAllByFotografo(fotografo);
    }

    /**
     * relativamente inefficiente, ma dovrebbe mettere una toppa al bug segnalato
     * sotto (condividono la stessa responsabilità)
     * @return
     */
    @Transactional
    public List<Album> primi10PerDataFraTutte() {
	List<Album> l = this.albumRepository.customFindAllByFotoDataInserimento();
	if (l.size() > 10) {
	    List<Album> shrink = new ArrayList<>();
	    for (int i = 10; i >= 0; i--) {
		shrink.add(l.get(i));
	    }
	    return shrink;
	}
	return l;
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
