package com.kdtech.gestion_escolar.service;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.kdtech.gestion_escolar.exception.ResourceNotFoundException;
import com.kdtech.gestion_escolar.model.Teacher;
import com.kdtech.gestion_escolar.repository.TeacherRepository;
import java.util.List;


@Service
public class TeacherService {
    
    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public List<Teacher> findAll() {
        return repository.findAll();
    }

    public Teacher save(@NonNull Teacher teacher) {
        return repository.save(teacher);
    }

    public Teacher update(@NonNull Teacher teacher) {

        Long id = teacher.getId();

        if (id == null || !repository.existsById(id)) {
            throw new ResourceNotFoundException("Teacher With id: " + id + " not found");
        }
        return repository.save(teacher);
    }

    public Teacher findById(@NonNull Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher With id: " + id + " not found"));
    }

    public void deleteById(@NonNull Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Teacher With id: " + id + " not found");
        }
        repository.deleteById(id);
    }
}
