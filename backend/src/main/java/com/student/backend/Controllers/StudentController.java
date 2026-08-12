package com.student.backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.student.backend.Models.StudentModel;
import com.student.backend.Services.StudentService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET
    @GetMapping("/api/student")
    public List<StudentModel> getAllStudents() {
        return studentService.getAllStudents();
    }

    // POST
    @PostMapping("/api/student")
    public void addStudent(@Valid @RequestBody StudentModel student) {
        studentService.addStudent(student);
    }

    // PUT
    @PutMapping("/api/student/{id}")
    public StudentModel updateStudent(@PathVariable Long id,
                                      @Valid @RequestBody StudentModel updatedStudent) {

        return studentService.updateStudent(id, updatedStudent);
    }

    // DELETE
    @DeleteMapping("/api/student/{id}")
    public String deleteStudent(@PathVariable Long id) {

        return studentService.deleteStudent(id);
    }
    // Search Student By Name
@GetMapping("/api/student/search")
public List<StudentModel> searchStudent(@RequestParam String name) {

    return studentService.searchStudentByName(name);

}
}