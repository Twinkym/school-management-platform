package com.kdtech.gestion_escolar.service;

import java.util.List;

import com.kdtech.gestion_escolar.model.Student;
import com.kdtech.gestion_escolar.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Student delete(Student student) {
        repository.delete(student);
        return student;
    }

    public Student update(Student student) {
        if (student.getId() == null || !repository.existsById(student.getId())) {
            throw new IllegalArgumentException("Student not found");
        }
        return repository.save(student);
    }

    public Student findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }
}
