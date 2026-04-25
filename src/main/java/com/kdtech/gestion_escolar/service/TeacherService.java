package com.kdtech.gestion_escolar.service;

import org.springframework.stereotype.Service;
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

    public Teacher save(Teacher teacher) {
        return repository.save(teacher);
    }

    public Teacher update(Teacher teacher) {
        if (teacher.getId() == null || !repository.existsById(teacher.getId())) {
            throw new IllegalArgumentException("Teacher not found");
        }
        return repository.save(teacher);
    }

    public Teacher findbyId(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Teacher not found"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Teacher delete(Teacher teacher) {
        repository.delete(teacher);
        return teacher;
    }
}
