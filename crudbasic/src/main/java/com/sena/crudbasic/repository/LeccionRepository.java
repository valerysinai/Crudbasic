package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Leccion;

@Repository
public interface LeccionRepository extends JpaRepository<Leccion, Integer> {
    // Buscar lecciones por curso
    List<Leccion> findByCurso_IdCurso(Integer idCurso);
    
    // Buscar lecciones por título
    List<Leccion> findByTituloContainingIgnoreCase(String titulo);
}