package com.sena.crudbasic.controller;

import com.sena.crudbasic.model.Instructor;
import com.sena.crudbasic.service.IInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructores")
@CrossOrigin(origins = "*")
public class InstructorController {
    
    @Autowired
    private IInstructorService instructorService;
    
    // Listar todos los instructores
    @GetMapping
    public ResponseEntity<List<Instructor>> findAll() {
        List<Instructor> instructores = instructorService.findAll();
        return ResponseEntity.ok(instructores);
    }
    
    // Buscar instructor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findById(@PathVariable Integer id) {
        Optional<Instructor> instructor = instructorService.findById(id);
        return instructor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Crear nuevo instructor
    @PostMapping
    public ResponseEntity<Instructor> create(@RequestBody Instructor instructor) {
        Instructor nuevoInstructor = instructorService.save(instructor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoInstructor);
    }
    
    // Actualizar instructor
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> update(@PathVariable Integer id, @RequestBody Instructor instructor) {
        try {
            Instructor instructorActualizado = instructorService.update(id, instructor);
            return ResponseEntity.ok(instructorActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Eliminar instructor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            instructorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}