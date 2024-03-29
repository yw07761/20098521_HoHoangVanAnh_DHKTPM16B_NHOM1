package com.example.objectservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.example.objectservice.Subject;
import com.example.objectservice.RequestSubject;

@RestController
@RequestMapping("/api/subjects")
public class SubjectService {

    private final String SUBJECT_API_URL = "http://localhost:8080/api/subjects"; // Đổi cổng 8080
    private final RestTemplate restTemplate;

    @Autowired
    public SubjectService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public void createSubject(@RequestBody RequestSubject requestSubject) {
        Subject subject = new Subject();
        subject.setName(requestSubject.getName());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Subject> request = new HttpEntity<>(subject, headers);
        restTemplate.postForObject(SUBJECT_API_URL, request, Subject.class);
    }

    @GetMapping
    public ResponseEntity<Subject[]> getAllSubjects() {
        return restTemplate.exchange(SUBJECT_API_URL, HttpMethod.GET, null, Subject[].class);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable("id") Long id) {
        String url = SUBJECT_API_URL + "/" + id;
        return restTemplate.exchange(url, HttpMethod.GET, null, Subject.class);
    }
}
