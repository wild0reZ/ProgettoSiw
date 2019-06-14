package it.silph.silphportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.silph.silphportal.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{

    public List<Album> findAllByOrderByFoto_DataInserimento();

    public List<Album> findFirst10ByOrderByFoto_DataInserimento();
}
