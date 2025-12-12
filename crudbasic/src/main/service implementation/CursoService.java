package com.sena.crudbasic.service.implementation;

import com.sena.crudbasic.model.Curso;
import com.sena.crudbasic.repository.CursoRepository;
import com.sena.crudbasic.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService implements ICursoService {
    
    @Autowired
    private CursoRepository cursoRepository;
    
    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }
    
    @Override
    public Optional<Curso> findById(Integer id) {
        return cursoRepository.findById(id);
    }
    
    @Override
    public List<Curso> findByTitulo(String titulo) {
        return cursoRepository.findByTituloContainingIgnoreCase(titulo);
    }
    
    @Override
    public List<Curso> findByInstructor(Integer idInstructor) {
        return cursoRepository.findByInstructor_IdInstructor(idInstructor);
    }
    
    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }
    
    @Override
    public Curso update(Integer id, Curso curso) {
        if (cursoRepository.existsById(id)) {
            curso.setIdCurso(id);
            return cursoRepository.save(curso);
        }
        throw new RuntimeException("Curso no encontrado con id: " + id);
    }
    
    @Override
    public void deleteById(Integer id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Curso no encontrado con id: " + id);
        }
    }
}