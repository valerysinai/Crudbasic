package com.sena.crudbasic.service.implementation;

import com.sena.crudbasic.model.Instructor;
import com.sena.crudbasic.repository.InstructorRepository;
import com.sena.crudbasic.service.IInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService implements IInstructorService {
    
    @Autowired
    private InstructorRepository instructorRepository;
    
    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }
    
    @Override
    public Optional<Instructor> findById(Integer id) {
        return instructorRepository.findById(id);
    }
    
    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }
    
    @Override
    public Instructor update(Integer id, Instructor instructor) {
        if (instructorRepository.existsById(id)) {
            instructor.setIdInstructor(id);
            return instructorRepository.save(instructor);
        }
        throw new RuntimeException("Instructor no encontrado con id: " + id);
    }
    
    @Override
    public void deleteById(Integer id) {
        if (instructorRepository.existsById(id)) {
            instructorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Instructor no encontrado con id: " + id);
        }
    }
}