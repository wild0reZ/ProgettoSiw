package it.silph.silphportal.repository;

import org.springframework.data.repository.CrudRepository;

import it.silph.silphportal.model.Album;

public interface AlbumRepository extends CrudRepository<Album, Long>{

}
