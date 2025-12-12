package com.sena.crudbasic.service.implementation;

import com.sena.crudbasic.model.Leccion;
import com.sena.crudbasic.repository.LeccionRepository;
import com.sena.crudbasic.service.ILeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LeccionService implements ILeccionService {
    
    @Autowired
    private LeccionRepository leccionRepository;
    
    @Override
    public List<Leccion> findAll() {
        return leccionRepository.findAll();
    }
    
    @Override
    public Optional<Leccion> findById(Integer id) {
        return leccionRepository.findById(id);
    }
    
    @Override
    public List<Leccion> findByCurso(Integer idCurso) {
        return leccionRepository.findByCurso_IdCurso(idCurso);
    }
    
    @Override
    public List<Leccion> findByTitulo(String titulo) {
        return leccionRepository.findByTituloContainingIgnoreCase(titulo);
    }
    
    @Override
    public Leccion save(Leccion leccion) {
        return leccionRepository.save(leccion);
    }
    
    @Override
    public Leccion update(Integer id, Leccion leccion) {
        if (leccionRepository.existsById(id)) {
            leccion.setIdLeccion(id);
            return leccionRepository.save(leccion);
        }
        throw new RuntimeException("Leccion no encontrada con id: " + id);
    }
    
    @Override
    public void deleteById(Integer id) {
        if (leccionRepository.existsById(id)) {
            leccionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Leccion no encontrada con id: " + id);
        }
    }
}