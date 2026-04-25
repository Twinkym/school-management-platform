package com.kdtech.gestion_escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kdtech.gestion_escolar.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
