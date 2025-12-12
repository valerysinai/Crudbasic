package com.sena.crudbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    // Métodos personalizados (si los necesitas)
}