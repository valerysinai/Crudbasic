package com.sena.crudbasic.controller;

import com.sena.crudbasic.model.Leccion;
import com.sena.crudbasic.service.ILeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lecciones")
@CrossOrigin(origins = "*")
public class LeccionController {
    
    @Autowired
    private ILeccionService leccionService;
    
    // Listar todas las lecciones
    @GetMapping
    public ResponseEntity<List<Leccion>> findAll() {
        List<Leccion> lecciones = leccionService.findAll();
        return ResponseEntity.ok(lecciones);
    }
    
    // Buscar lección por ID
    @GetMapping("/{id}")
    public ResponseEntity<Leccion> findById(@PathVariable Integer id) {
        Optional<Leccion> leccion = leccionService.findById(id);
        return leccion.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Buscar lecciones por curso
    @GetMapping("/curso/{idCurso}")
    public ResponseEntity<List<Leccion>> findByCurso(@PathVariable Integer idCurso) {
        List<Leccion> lecciones = leccionService.findByCurso(idCurso);
        return ResponseEntity.ok(lecciones);
    }
    
    // Buscar lecciones por título
    @GetMapping("/buscar")
    public ResponseEntity<List<Leccion>> findByTitulo(@RequestParam String titulo) {
        List<Leccion> lecciones = leccionService.findByTitulo(titulo);
        return ResponseEntity.ok(lecciones);
    }
    
    // Crear nueva lección
    @PostMapping
    public ResponseEntity<Leccion> create(@RequestBody Leccion leccion) {
        Leccion nuevaLeccion = leccionService.save(leccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaLeccion);
    }
    
    // Actualizar lección
    @PutMapping("/{id}")
    public ResponseEntity<Leccion> update(@PathVariable Integer id, @RequestBody Leccion leccion) {
        try {
            Leccion leccionActualizada = leccionService.update(id, leccion);
            return ResponseEntity.ok(leccionActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Eliminar lección
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            leccionService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}