package com.sena.crudbasic.service;

import com.sena.crudbasic.model.Instructor;
import java.util.List;
import java.util.Optional;

public interface IInstructorService {
    // Listar todos
    List<Instructor> findAll();
    
    // Buscar por ID
    Optional<Instructor> findById(Integer id);
    
    // Crear
    Instructor save(Instructor instructor);
    
    // Actualizar
    Instructor update(Integer id, Instructor instructor);
    
    // Eliminar
    void deleteById(Integer id);
}