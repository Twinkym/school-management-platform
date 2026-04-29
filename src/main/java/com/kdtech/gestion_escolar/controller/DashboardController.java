package com.kdtech.gestion_escolar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.kdtech.gestion_escolar.repository.StudentRepository;
import com.kdtech.gestion_escolar.repository.TeacherRepository;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public DashboardController(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @GetMapping
    public String getDashboard(Model model) {
        long totalStudents = studentRepository.count();
        long totalTeachers = teacherRepository.count();

        model.addAttribute("totalStudents", totalStudents);
        model.addAttribute("totalTeachers", totalTeachers);

        return "dashboard/admin-dashboard";
    }
}
