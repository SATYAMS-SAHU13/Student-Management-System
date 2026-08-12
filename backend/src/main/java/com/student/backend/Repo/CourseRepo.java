package com.student.backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.backend.Models.CourseModel;

public interface CourseRepo extends JpaRepository<CourseModel, Long> {

}
