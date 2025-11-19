package com.AmigosProject.Project.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmigosProject.Project.model.student;
import com.AmigosProject.Project.repo.studentRepo;

@Service
public class studentService {
    @Autowired
    private studentRepo repo;

    public List<student> getAllStudents(){
        return repo.findAll();
    }

    public void addStudent(student newStudent){
        Optional <student> studentOptional = repo.findByEmail(newStudent.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("User already Exists");
        }
            repo.save(newStudent);
    }

    public void deleteStudent(UUID id) {
        boolean exists = repo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Student with id " + id + " does not exist");
        }
        repo.deleteById(id);
    }
}
