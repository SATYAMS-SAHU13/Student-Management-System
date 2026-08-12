package com.student.backend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.NotBlank;

@Entity
public class CourseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course name is required")
    private String courseName;

    @NotBlank(message = "Duration is required")
    private String duration;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private StudentModel student;

    // Default Constructor
    public CourseModel() {
    }

    // Parameterized Constructor
    public CourseModel(Long id, String courseName, String duration, StudentModel student) {
        this.id = id;
        this.courseName = courseName;
        this.duration = duration;
        this.student = student;
    }

    // Getter

    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDuration() {
        return duration;
    }

    public StudentModel getStudent() {
        return student;
    }

    // Setter

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }
}