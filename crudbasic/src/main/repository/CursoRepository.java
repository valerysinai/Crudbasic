package com.sena.crudbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.crudbasic.model.Curso;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    // Buscar cursos por título
    List<Curso> findByTituloContainingIgnoreCase(String titulo);
    
    // Buscar cursos por instructor
    List<Curso> findByInstructor_IdInstructor(Integer idInstructor);
}