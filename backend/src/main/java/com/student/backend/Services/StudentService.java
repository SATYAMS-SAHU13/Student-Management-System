package com.student.backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.backend.Exception.ResourceNotFoundException;
import com.student.backend.Models.CourseModel;
import com.student.backend.Models.StudentModel;
import com.student.backend.Repo.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    // Get All Students
    public List<StudentModel> getAllStudents() {
        return studentRepo.findAll();
    }

    // Add Student
    public void addStudent(StudentModel student) {

        // Set Student reference in each Course
        if (student.getCourses() != null) {
            for (CourseModel course : student.getCourses()) {
                course.setStudent(student);
            }
        }

        studentRepo.save(student);
    }

    // Update Student
    public StudentModel updateStudent(Long id, StudentModel updatedStudent) {

        StudentModel student = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());

        // Set Student reference in each Course
        if (updatedStudent.getCourses() != null) {
            for (CourseModel course : updatedStudent.getCourses()) {
                course.setStudent(student);
            }
        }

        student.setCourses(updatedStudent.getCourses());

        return studentRepo.save(student);
    }

    // Delete Student
    public String deleteStudent(Long id) {

       if (studentRepo.existsById(id)) {
    studentRepo.deleteById(id);
    return "Student deleted successfully";
} else {
    throw new ResourceNotFoundException("Student not found");
}
    }

    // Search Student By Name
public List<StudentModel> searchStudentByName(String name) {
    return studentRepo.findByNameContainingIgnoreCase(name);
}
}