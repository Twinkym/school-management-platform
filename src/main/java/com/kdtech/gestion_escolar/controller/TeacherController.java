package com.kdtech.gestion_escolar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kdtech.gestion_escolar.model.Teacher;
import com.kdtech.gestion_escolar.service.TeacherService;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("teachers", service.findAll());
        return "teachers/list";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teachers/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Teacher teacher) {
        service.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("teacher", service.findById(id));
        return "teachers/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/teachers";
    }

}
