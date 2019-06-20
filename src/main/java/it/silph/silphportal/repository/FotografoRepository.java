package it.silph.silphportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.silph.silphportal.model.Fotografo;

@Repository
public interface FotografoRepository extends JpaRepository<Fotografo, Long> {

    // @Query(value = "SELECT DISTINCT a.fotografo, MAX(f.dataInserimento) FROM
    // Fotografo fo, Album a, Foto f WHERE fo.id = a.fotografo.id")
    public List<Fotografo> findAllByOrderByAlbum_Foto_DataInserimentoDesc();

    public List<Fotografo> findByNomeOrCognomeContainingIgnoreCase(String nome, String cognome);

    @Query(
	    value = "SELECT DISTINCT f FROM Fotografo f WHERE LOWER(f.nome) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(f.cognome) LIKE LOWER(CONCAT('%', :query, '%'))"
	    )
    public List<Fotografo> findByNomeCognomeCustomQuery(@Param("query") String query);

}
