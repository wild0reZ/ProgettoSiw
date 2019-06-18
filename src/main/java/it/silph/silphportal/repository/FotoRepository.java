package it.silph.silphportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.silph.silphportal.model.Album;
import it.silph.silphportal.model.Foto;
import it.silph.silphportal.model.Modulo;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {
    public List<Foto> findAllByOrderByDataInserimento();

    public List<Foto> findFirst9ByOrderByDataInserimento();

    public List<Foto> findAllByAlbum(Album a);
    
    @Query("SELECT DISTINCT f FROM Foto f, Modulo m WHERE m.id = :id")
    public List<Foto> findAllByModuloId(@Param("id") Long id);

    @Query("SELECT f FROM Foto f WHERE f.titoloFoto LIKE %:query%")
    public List<Foto> searchAllByQuery(@Param("query") String query);

    public List<Foto> findByTitoloFotoContainingIgnoreCase(String titolo);
}
