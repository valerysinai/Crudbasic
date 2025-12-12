package com.sena.crudbasic.service;

import java.util.List;
import java.util.Optional;

import com.sena.crudbasic.model.Leccion;

public interface ILeccionService {
    // Listar todas
    List<Leccion> findAll();
    
    // Buscar por ID
    Optional<Leccion> findById(Integer id);
    
    // Buscar por curso
    List<Leccion> findByCurso(Integer idCurso);
    
    // Buscar por título
    List<Leccion> findByTitulo(String titulo);
    
    // Crear
    Leccion save(Leccion leccion);
    
    // Actualizar
    Leccion update(Integer id, Leccion leccion);
    
    // Eliminar
    void deleteById(Integer id);
}