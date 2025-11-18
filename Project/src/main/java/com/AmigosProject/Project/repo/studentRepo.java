package com.AmigosProject.Project.repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AmigosProject.Project.model.student;

@Repository
public interface studentRepo extends JpaRepository<student, UUID>{
    //select * from student where email = ?
    Optional <student> findByEmail(String email);
    
}
