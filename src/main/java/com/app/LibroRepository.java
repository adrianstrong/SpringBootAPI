package com.app;

import java.util.List;
import java.util.Optional;

import models.Libro;
import models.LibroProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

public interface LibroRepository extends JpaRepository<models.Libro, Integer> {

    List<Libro> findByCategoria(String categoria);
    List<Libro> findByAutor(String autor);
    @Query("select l.estado from Libro l where l.id = ?1")
    String findEstadoById(Integer Id);

}
