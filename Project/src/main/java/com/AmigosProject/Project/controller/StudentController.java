package com.AmigosProject.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/students")
    public ResponseEntity<Void> addStudent(@RequestBody student newStudent){
        service.addStudent(newStudent);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
