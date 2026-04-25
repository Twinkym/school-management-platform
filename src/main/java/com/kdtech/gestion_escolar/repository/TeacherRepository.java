package com.kdtech.gestion_escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kdtech.gestion_escolar.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    
}
