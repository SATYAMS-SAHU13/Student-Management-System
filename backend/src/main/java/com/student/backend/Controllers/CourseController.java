package com.student.backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.student.backend.Models.CourseModel;
import com.student.backend.Services.CourseService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // GET All Courses
    @GetMapping("/api/course")
    public List<CourseModel> getAllCourses() {
        return courseService.getAllCourses();
    }

    // GET Course By Id
    @GetMapping("/api/course/{id}")
    public CourseModel getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    // POST Course
    @PostMapping("/api/course")
    public void addCourse(@Valid @RequestBody CourseModel course) {
        courseService.addCourse(course);
    }

    // PUT Course
    @PutMapping("/api/course/{id}")
    public CourseModel updateCourse(@PathVariable Long id,
                                    @Valid @RequestBody CourseModel updatedCourse) {

        return courseService.updateCourse(id, updatedCourse);
    }

    // DELETE Course
    @DeleteMapping("/api/course/{id}")
    public String deleteCourse(@PathVariable Long id) {

        return courseService.deleteCourse(id);
    }
}