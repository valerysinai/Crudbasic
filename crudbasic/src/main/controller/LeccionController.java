package com.sena.crudbasic.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crudbasic.model.Leccion;
import com.sena.crudbasic.model.Views;
import com.sena.crudbasic.service.ILeccionService;
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
@RequestMapping("/api/lecciones")
@CrossOrigin(origins = "*")
@Tag(name = "Lecciones", description = "API para gestión de lecciones")
public class LeccionController {
    
    @Autowired
    private ILeccionService leccionService;
    
    @GetMapping
    @JsonView(Views.Basic.class)
    @Operation(summary = "Listar todas las lecciones")
    public ResponseEntity<List<Leccion>> findAll() {
        List<Leccion> lecciones = leccionService.findAll();
        return ResponseEntity.ok(lecciones);
    }
    
    @GetMapping("/{id}")
    @JsonView(Views.Detailed.class)
    @Operation(summary = "Buscar lección por ID con detalles")
    public ResponseEntity<Leccion> findById(@PathVariable Integer id) {
        Optional<Leccion> leccion = leccionService.findById(id);
        return leccion.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/curso/{idCurso}")
    @JsonView(Views.Detailed.class)
    @Operation(summary = "Buscar lecciones por curso")
    public ResponseEntity<List<Leccion>> findByCurso(@PathVariable Integer idCurso) {
        List<Leccion> lecciones = leccionService.findByCurso(idCurso);
        return ResponseEntity.ok(lecciones);
    }
    
    @GetMapping("/buscar")
    @JsonView(Views.Basic.class)
    @Operation(summary = "Buscar lecciones por título")
    public ResponseEntity<List<Leccion>> findByTitulo(@RequestParam String titulo) {
        List<Leccion> lecciones = leccionService.findByTitulo(titulo);
        return ResponseEntity.ok(lecciones);
    }
    
    @PostMapping
    @JsonView(Views.Basic.class)
    @Operation(summary = "Crear nueva lección")
    public ResponseEntity<Leccion> create(@Valid @RequestBody Leccion leccion) {
        Leccion nuevaLeccion = leccionService.save(leccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaLeccion);
    }
    
    @PutMapping("/{id}")
    @JsonView(Views.Basic.class)
    @Operation(summary = "Actualizar lección")
    public ResponseEntity<Leccion> update(@PathVariable Integer id, 
                                         @Valid @RequestBody Leccion leccion) {
        try {
            Leccion leccionActualizada = leccionService.update(id, leccion);
            return ResponseEntity.ok(leccionActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar lección")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            leccionService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}