package com.sena.crudbasic.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crudbasic.model.Curso;
import com.sena.crudbasic.model.Views;
import com.sena.crudbasic.service.ICursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*")
@Tag(name = "Cursos", description = "API para gestión de cursos")
public class CursoController {
    
    @Autowired
    private ICursoService cursoService;
    
    @GetMapping
    @JsonView(Views.Basic.class)
    @Operation(summary = "Listar todos los cursos")
    public ResponseEntity<List<Curso>> findAll() {
        List<Curso> cursos = cursoService.findAll();
        return ResponseEntity.ok(cursos);
    }
    
    @GetMapping("/{id}")
    @JsonView(Views.Detailed.class)
    @Operation(summary = "Buscar curso por ID con detalles")
    public ResponseEntity<Curso> findById(@PathVariable Integer id) {
        Optional<Curso> curso = cursoService.findById(id);
        return curso.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/buscar")
    @JsonView(Views.Basic.class)
    @Operation(summary = "Buscar cursos por título")
    public ResponseEntity<List<Curso>> findByTitulo(@RequestParam String titulo) {
        List<Curso> cursos = cursoService.findByTitulo(titulo);
        return ResponseEntity.ok(cursos);
    }
    
    @GetMapping("/instructor/{idInstructor}")
    @JsonView(Views.Detailed.class)
    @Operation(summary = "Buscar cursos por instructor")
    public ResponseEntity<List<Curso>> findByInstructor(@PathVariable Integer idInstructor) {
        List<Curso> cursos = cursoService.findByInstructor(idInstructor);
        return ResponseEntity.ok(cursos);
    }
    
    @PostMapping
    @JsonView(Views.Basic.class)
    @Operation(summary = "Crear nuevo curso")
    public ResponseEntity<Curso> create(@Valid @RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCurso);
    }
    
    @PutMapping("/{id}")
    @JsonView(Views.Basic.class)
    @Operation(summary = "Actualizar curso")
    public ResponseEntity<Curso> update(@PathVariable Integer id, 
                                       @Valid @RequestBody Curso curso) {
        try {
            Curso cursoActualizado = cursoService.update(id, curso);
            return ResponseEntity.ok(cursoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar curso")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            cursoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}