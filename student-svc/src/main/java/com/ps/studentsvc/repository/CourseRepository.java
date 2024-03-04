package com.ps.studentsvc.repository;

import com.ps.studentsvc.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
