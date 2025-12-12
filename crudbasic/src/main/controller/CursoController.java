package com.sena.crudbasic.controller;

import com.sena.crudbasic.model.Curso;
import com.sena.crudbasic.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*")
public class CursoController {
    
    @Autowired
    private ICursoService cursoService;
    
    // Listar todos los cursos
    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        List<Curso> cursos = cursoService.findAll();
        return ResponseEntity.ok(cursos);
    }
    
    // Buscar curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Integer id) {
        Optional<Curso> curso = cursoService.findById(id);
        return curso.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Buscar cursos por título
    @GetMapping("/buscar")
    public ResponseEntity<List<Curso>> findByTitulo(@RequestParam String titulo) {
        List<Curso> cursos = cursoService.findByTitulo(titulo);
        return ResponseEntity.ok(cursos);
    }
    
    // Buscar cursos por instructor
    @GetMapping("/instructor/{idInstructor}")
    public ResponseEntity<List<Curso>> findByInstructor(@PathVariable Integer idInstructor) {
        List<Curso> cursos = cursoService.findByInstructor(idInstructor);
        return ResponseEntity.ok(cursos);
    }
    
    // Crear nuevo curso
    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCurso);
    }
    
    // Actualizar curso
    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Integer id, @RequestBody Curso curso) {
        try {
            Curso cursoActualizado = cursoService.update(id, curso);
            return ResponseEntity.ok(cursoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Eliminar curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            cursoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}