package it.silph.silphportal.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.silph.silphportal.model.Foto;
import it.silph.silphportal.repository.FotoRepository;

@Service
public class FotoService {
    @Autowired
    private FotoRepository fotoRepository;
    
    @Transactional
    public Foto aggiungiFoto(Foto foto) {
	return fotoRepository.save(foto);
    }

    @Transactional
    public Foto fotoPerId(Long id) {
	return fotoRepository.findById(id).get();
    }
    
////    @Transactional
////    public List<Foto> fotoPiuRecenti(LocalDate dataInserimento){
////	return fotoRepository.findFirst9ByDataInserimento(dataInserimento);
////    }
////    
//    @Transactional
//    public List<Foto> fotoPerTitoloETag(String titolo, List<String> tags) {
//	return fotoRepository.findFirst9ByTitoloAndTagsIn(titolo, tags);
//    }
//    
}
