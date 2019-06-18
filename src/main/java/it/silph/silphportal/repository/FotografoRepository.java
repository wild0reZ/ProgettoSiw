package it.silph.silphportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.silph.silphportal.model.Album;
import it.silph.silphportal.model.Fotografo;

@Repository
public interface FotografoRepository extends JpaRepository<Fotografo, Long> {

    //@Query(value = "SELECT DISTINCT a.fotografo, MAX(f.dataInserimento) FROM Fotografo fo, Album a, Foto f WHERE fo.id = a.fotografo.id")
    public List<Fotografo>  findAllByOrderByAlbum_Foto_DataInserimento();

    public List<Fotografo> findByNomeOrCognomeContainingIgnoreCase(String nome, String cognome);

}
