package com.AmigosProject.Project.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class student {
    @Id
    @GeneratedValue
    private UUID id;

    private String email;
    private String name;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dob;

    @Transient
    @JsonIgnore
    public Integer getAge(){
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
