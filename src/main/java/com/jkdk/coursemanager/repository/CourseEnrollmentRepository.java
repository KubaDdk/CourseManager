package com.jkdk.coursemanager.repository;

import com.jkdk.coursemanager.model.CourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, Long> {
}
