package it.silph.silphportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.silph.silphportal.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{

}
