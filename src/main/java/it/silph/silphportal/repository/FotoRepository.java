package it.silph.silphportal.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.silph.silphportal.model.Foto;

public interface FotoRepository extends CrudRepository<Foto, Long> {
    public List<Foto> findFirst9ByTitoloAndTagsIn(String titolo, List<String> tags);
    public List<Foto> findFirst9ByDataInserimento(LocalDate dataInserimento);
}
