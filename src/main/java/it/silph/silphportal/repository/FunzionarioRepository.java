package it.silph.silphportal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.silph.silphportal.model.Funzionario;

@Repository
public interface FunzionarioRepository extends CrudRepository<Funzionario, Long>{

}
