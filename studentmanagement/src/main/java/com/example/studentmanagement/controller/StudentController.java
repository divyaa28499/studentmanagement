package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    // Add Student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {

        return repository.save(student);
    }

    // Get All Students
    @GetMapping
    public List<Student> getStudents() {

        return repository.findAll();
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {

        repository.deleteById(id);

        return "Student deleted successfully";
    }
}