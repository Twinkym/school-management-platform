package com.kdtech.gestion_escolar.service;

import java.util.List;

import com.kdtech.gestion_escolar.exception.ResourceNotFoundException;
import com.kdtech.gestion_escolar.model.Student;
import com.kdtech.gestion_escolar.repository.StudentRepository;

import org.springframework.lang.NonNull;
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

    public Student save(@NonNull Student student) {
        return repository.save(student);
    }

    public void deleteById(@NonNull Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Student With id: " + id + " not found");
        }
        repository.deleteById(id);
    }

    public Student update(@NonNull Student student) {

        Long id = student.getId();

        if (id == null || !repository.existsById(id)) {
            throw new ResourceNotFoundException("Student With id: " + id + " not found");
        }
        return repository.save(student);
    }

    public Student findById(@NonNull Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student With id: " + id + " not found"));
    }
}
