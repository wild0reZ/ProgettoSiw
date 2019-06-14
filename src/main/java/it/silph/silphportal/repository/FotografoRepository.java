package it.silph.silphportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.silph.silphportal.model.Fotografo;

@Repository
public interface FotografoRepository extends JpaRepository<Fotografo, Long>{

    public List<Fotografo> findFirst9ByOrderByAlbum_Foto_DataInserimento();

}
