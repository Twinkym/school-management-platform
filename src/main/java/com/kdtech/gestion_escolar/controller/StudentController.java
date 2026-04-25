package com.kdtech.gestion_escolar.controller;

import com.kdtech.gestion_escolar.model.Student;
import com.kdtech.gestion_escolar.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/students")
public class StudentController {
    
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", service.findAll());
        return "students/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.findById(id));
        return "students/form";
    }

    @PostMapping("/save")
    public String save(Student student, RedirectAttributes redirectAttributes) {
        boolean isNew = (student.getId() == null);

        service.save(student);
        if (isNew) {
            redirectAttributes.addFlashAttribute("success", "Student created successfully.");
        } else {
            redirectAttributes.addFlashAttribute("success", "Student updated successfully.");
        }
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        service.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Student deleted successfully.");
        return "redirect:/students";
    }
}
