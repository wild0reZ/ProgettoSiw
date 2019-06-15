package it.silph.silphportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.silph.silphportal.model.Immagine;

@Repository
public interface ImmagineRepository extends JpaRepository<Immagine, Long>{

}
