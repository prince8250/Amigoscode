package com.AmigosProject.Project.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AmigosProject.Project.model.student;
import com.AmigosProject.Project.service.studentService;


@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private studentService service;

    @GetMapping("/students")
    public ResponseEntity<List<student>> getAllStudents(){
        return new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Optional<student>> getStudentById(@PathVariable UUID id){
        return new ResponseEntity<>(service.getStudentById(id),HttpStatus.FOUND);
    }

    @PostMapping("/students")
    public ResponseEntity<Void> addStudent(@RequestBody student newStudent){
        service.addStudent(newStudent);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable UUID id){
        service.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable UUID id, @RequestBody student updateStud){
        service.updateStudent(id,updateStud);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
