package it.silph.silphportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.silph.silphportal.model.Album;
import it.silph.silphportal.model.Fotografo;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    /**
     * Causano troppi problemi, meglio custom Query 
     * public List<Album> findAllByOrderByFoto_DataInserimento();
     *
     * public List<Album> findFirst10ByOrderByFoto_DataInserimento();
     */

    @Query(value = "SELECT DISTINCT a, MAX(f.dataInserimento) FROM Album a, Foto f GROUP BY a ORDER BY MAX(f.dataInserimento) DESC")
    public List<Album> customFindAllByFotoDataInserimento();

    public List<Album> findAllByFotografo(Fotografo fotografo);
}
