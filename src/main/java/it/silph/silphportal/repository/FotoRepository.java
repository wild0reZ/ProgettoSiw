package it.silph.silphportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.silph.silphportal.model.Foto;

public interface FotoRepository extends JpaRepository<Foto, Long> {
    public List<Foto> findAllByOrderByDataInserimento();
}
