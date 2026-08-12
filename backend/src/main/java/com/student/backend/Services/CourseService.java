package com.student.backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.backend.Exception.ResourceNotFoundException;
import com.student.backend.Models.CourseModel;
import com.student.backend.Repo.CourseRepo;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    // Get All Courses
    public List<CourseModel> getAllCourses() {
        return courseRepo.findAll();
    }

    // Add Course
    public void addCourse(CourseModel course) {
        courseRepo.save(course);
    }

    // Update Course
    public CourseModel updateCourse(Long id, CourseModel updatedCourse) {

        CourseModel course = courseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        course.setCourseName(updatedCourse.getCourseName());
        course.setDuration(updatedCourse.getDuration());

        return courseRepo.save(course);
    }

    // Delete Course
    public String deleteCourse(Long id) {

        if (courseRepo.existsById(id)) {
            courseRepo.deleteById(id);
            return "Course deleted successfully";
        } else {
            throw new ResourceNotFoundException("Course not found");
        }
    }

    // Get Course By Id
    public CourseModel getCourseById(Long id) {

        return courseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }
}