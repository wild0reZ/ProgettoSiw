package it.silph.silphportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.silph.silphportal.model.Fotografo;
import it.silph.silphportal.repository.FotografoRepository;

@Service
public class FotografoService {

    @Autowired
    private FotografoRepository fotografoRepository;

    @Transactional
    public List<Fotografo> primi9PerData() {
	return this.fotografoRepository.findFirst9ByOrderByAlbum_Foto_DataInserimento();
    }

}
