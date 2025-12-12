package com.sena.crudbasic.service;

import java.util.List;
import java.util.Optional;

import com.sena.crudbasic.model.Curso;

public interface ICursoService {
    // Listar todos
    List<Curso> findAll();
    
    // Buscar por ID
    Optional<Curso> findById(Integer id);
    
    // Buscar por título
    List<Curso> findByTitulo(String titulo);
    
    // Buscar por instructor
    List<Curso> findByInstructor(Integer idInstructor);
    
    // Crear
    Curso save(Curso curso);
    
    // Actualizar
    Curso update(Integer id, Curso curso);
    
    // Eliminar
    void deleteById(Integer id);
}