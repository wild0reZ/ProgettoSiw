package it.silph.silphportal.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.silph.silphportal.model.Album;
import it.silph.silphportal.model.Foto;
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
	return this.albumRepository.findAllByOrderByFoto_DataInserimentoDesc();
    }

    @Transactional
    public List<Album> tuttiPerFotografo(Fotografo fotografo) {
	return this.albumRepository.findAllByFotografo(fotografo);
    }

    /**
     * relativamente inefficiente, ma dovrebbe mettere una toppa al bug segnalato
     * sotto (condividono la stessa responsabilità)
     * 
     * @return
     */
    @Transactional
    public List<Album> primi10PerDataFraTutte() {
	List<Album> l = removeDuplicates(this.albumRepository.findAllByOrderByFoto_DataInserimentoDesc());
	if (l.size() > 10) {
	    List<Album> shrink = new ArrayList<>();
	    for (int i = 10; i >= 0; i--) { // FORSE DEVI CAMBIARNE IL VERSO!!!
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

    @Transactional
    public void addFoto(Long id, Foto foto) {
	Album a = this.albumRepository.getOne(id);
	a.addFoto(foto);
	this.albumRepository.save(a);
    }

    @Transactional
    public void inserisci(Album album) {
	this.albumRepository.save(album);
    }

    @Transactional
    public void searchAlbum(List<Album> albumSearch, String query) {
	List<Album> album = this.albumRepository.findByTitoloAlbumContainingIgnoreCase(query);
	albumSearch.addAll(album);
    }

    @Transactional
    public void primi10PerDataFraTutteFix(List<Album> gruppoAlbum) {
	List<Album> l = removeDuplicates(this.albumRepository.findAllByOrderByFoto_DataInserimentoDesc());
	if (l.size() > 10) {
	    List<Album> shrink = new ArrayList<>();
	    for (int i = 0; i >= 10; i--) { // FORSE DEVI CAMBIARNE IL VERSO!!!
		shrink.add(l.get(i));
	    }
	}
	gruppoAlbum.addAll(l);
    }

    /**
     * Altro complice di questa mostruosità (vedi sopra)
     * 
     * @param l
     * @return
     */
    private List<Album> removeDuplicates(List<Album> l) {
	return l.stream().distinct().collect(Collectors.toList());
    }

}
