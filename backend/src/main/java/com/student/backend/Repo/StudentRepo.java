package com.student.backend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.backend.Models.StudentModel;

public interface StudentRepo extends JpaRepository<StudentModel, Long> {
      List<StudentModel> findByNameContainingIgnoreCase(String name);
}
