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
import it.silph.silphportal.model.Fotografo;
import it.silph.silphportal.repository.FotografoRepository;

@Service
public class FotografoService {

    @Autowired
    private FotografoRepository fotografoRepository;

    @Transactional
    public List<Fotografo> tuttiPerData() {
	return removeDuplicates(this.fotografoRepository.findAllByOrderByAlbum_Foto_DataInserimentoDesc());
    }

    /**
     * Hackerata brutta...ma funziona (ahime), quando saprò scrivere in jqpl ne
     * riparliamo
     * 
     * @return
     */
    @Transactional
    public List<Fotografo> primi9PerDataFraTutti() {
	List<Fotografo> f = removeDuplicates(this.fotografoRepository.findAllByOrderByAlbum_Foto_DataInserimentoDesc());
	if (f.size() > 9) {
	    List<Fotografo> shrink = new ArrayList<>();
	    for (int i = 9; i >= 0; i--) { // FORSE DEVI CAMBIARE VERSO!!!
		shrink.add(f.get(i));
	    }
	    return shrink;
	}
	return f;
    }

    /**
     * Altro complice di questa mostruosità (vedi sopra)
     * 
     * @param l
     * @return
     */
    private List<Fotografo> removeDuplicates(List<Fotografo> l) {
	return l.stream().distinct().collect(Collectors.toList());
    }

    public Page<Fotografo> findPaginated(Pageable pageable, List<Fotografo> gruppoFotografo) {
	int pageSize = pageable.getPageSize();
	int currentPage = pageable.getPageNumber();
	int startItem = currentPage * pageSize;
	List<Fotografo> list;

	if (gruppoFotografo.size() < startItem) {
	    list = Collections.emptyList();
	} else {
	    int toIndex = Math.min(startItem + pageSize, gruppoFotografo.size());
	    list = gruppoFotografo.subList(startItem, toIndex);
	}

	Page<Fotografo> fotografoPage = new PageImpl<Fotografo>(list, PageRequest.of(currentPage, pageSize),
		gruppoFotografo.size());

	return fotografoPage;
    }

    @Transactional
    public Fotografo trovaPerId(Long id) {
	return this.fotografoRepository.findById(id).get();
    }

    @Transactional
    public void inserisci(Fotografo fotografo) {
	this.fotografoRepository.save(fotografo);
    }

    @Transactional
    public void addAlbum(Long id, Album album) {
	Fotografo fotografo = this.fotografoRepository.getOne(id);
	fotografo.addAlbum(album);
	this.fotografoRepository.save(fotografo);
    }

    @Transactional
    public void searchFoto(List<Fotografo> albumSearch, String query) {
	List<Fotografo> fotografi = this.fotografoRepository.findByNomeCognomeCustomQuery(query);
	albumSearch.addAll(fotografi);
    }

    @Transactional
    public void primi9PerDataFraTuttiFix(List<Fotografo> gruppoFotografo) {
	List<Fotografo> f = removeDuplicates(this.fotografoRepository.findAllByOrderByAlbum_Foto_DataInserimentoDesc());
	if (f.size() > 9) {
	    List<Fotografo> shrink = new ArrayList<>();
	    for (int i = 9; i >= 10; i--) { // FORSE DEVI CAMBIARE VERSO!!!
		shrink.add(f.get(i));
	    }
	}
	gruppoFotografo.addAll(f);
    }

}