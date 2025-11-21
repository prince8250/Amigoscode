package com.AmigosProject.Project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmigosProject.Project.model.student;
import com.AmigosProject.Project.repo.studentRepo;

import jakarta.transaction.Transactional;

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

    public Optional<student> getStudentById(UUID id) {
        Optional <student> StudentOptional = repo.findById(id);
        if(!StudentOptional.isPresent()){
            throw new IllegalStateException("Student does not exist.");
        }
        return StudentOptional;
    }

    @Transactional
    public void updateStudent(UUID id, student updateStud){
        student existingStud = repo.findById(id)
            .orElseThrow(()-> new IllegalStateException("Sudent does not exist."));

        String newName=updateStud.getName();
        if(updateStud.getName()== null || updateStud.getName().isEmpty()){
            throw new IllegalStateException("Name field is required!");
        }

        String newEmail=updateStud.getEmail();
        if(updateStud.getEmail() == null || updateStud.getEmail().isEmpty()){
            throw new IllegalStateException("Email field is required!");
        }

        LocalDate newDob=updateStud.getDob();
        if(updateStud.getDob() == null){
            throw new IllegalStateException("Date of Birth field is required!");
        }

        existingStud.setName(newName);
        existingStud.setDob(newDob);
        existingStud.setEmail(newEmail);
    }
}
