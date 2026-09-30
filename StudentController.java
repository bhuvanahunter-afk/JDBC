package com.example.student;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Student> getStudents() {
        return repository.getAllStudents();
    }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        repository.addStudent(student);
        return "Student added successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        repository.deleteStudent(id);
        return "Student deleted successfully!";
    }
}
