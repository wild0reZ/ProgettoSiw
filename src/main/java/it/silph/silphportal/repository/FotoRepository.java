package it.silph.silphportal.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.silph.silphportal.model.Foto;

public interface FotoRepository extends CrudRepository<Foto, Long> {
    
}
