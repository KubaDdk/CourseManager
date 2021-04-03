package com.jkdk.coursemanager.repository;

import com.jkdk.coursemanager.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
