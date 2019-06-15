package it.silph.silphportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.silph.silphportal.model.Album;
import it.silph.silphportal.model.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {
    public List<Foto> findAllByOrderByDataInserimento();

    public List<Foto> findFirst9ByOrderByDataInserimento();

    public List<Foto> findAllByAlbum(Album a);
}
