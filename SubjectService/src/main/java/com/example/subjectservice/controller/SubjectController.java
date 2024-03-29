package com.example.subjectservice.controller;

import com.example.subjectservice.models.Subject;
import com.example.subjectservice.repositoties.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @PostMapping
    public Subject addSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable("id") Long id) {
        return subjectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Subject not found with id: " + id));
    }

    @GetMapping
    public Iterable<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}
