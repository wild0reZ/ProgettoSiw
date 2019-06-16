package it.silph.silphportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.silph.silphportal.model.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long>{

}
