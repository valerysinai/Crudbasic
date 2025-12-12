package com.sena.crudbasic.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crudbasic.model.Instructor;
import com.sena.crudbasic.model.Views;
import com.sena.crudbasic.service.IInstructorService;
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
@RequestMapping("/api/instructores")
@CrossOrigin(origins = "*")
@Tag(name = "Instructores", description = "API para gestión de instructores")
public class InstructorController {
    
    @Autowired
    private IInstructorService instructorService;
    
    @GetMapping
    @JsonView(Views.Basic.class)
    @Operation(summary = "Listar todos los instructores")
    public ResponseEntity<List<Instructor>> findAll() {
        List<Instructor> instructores = instructorService.findAll();
        return ResponseEntity.ok(instructores);
    }
    
    @GetMapping("/{id}")
    @JsonView(Views.Basic.class)
    @Operation(summary = "Buscar instructor por ID")
    public ResponseEntity<Instructor> findById(@PathVariable Integer id) {
        Optional<Instructor> instructor = instructorService.findById(id);
        return instructor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    @JsonView(Views.Basic.class)
    @Operation(summary = "Crear nuevo instructor")
    public ResponseEntity<Instructor> create(@Valid @RequestBody Instructor instructor) {
        Instructor nuevoInstructor = instructorService.save(instructor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoInstructor);
    }
    
    @PutMapping("/{id}")
    @JsonView(Views.Basic.class)
    @Operation(summary = "Actualizar instructor")
    public ResponseEntity<Instructor> update(@PathVariable Integer id, 
                                            @Valid @RequestBody Instructor instructor) {
        try {
            Instructor instructorActualizado = instructorService.update(id, instructor);
            return ResponseEntity.ok(instructorActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar instructor")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            instructorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}