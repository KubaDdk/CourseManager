package com.jkdk.coursemanager.service;

import com.jkdk.coursemanager.model.CourseEnrollment;
import com.jkdk.coursemanager.repository.CourseEnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseEnrollmentService {

    private final CourseEnrollmentRepository courseEnrollmentRepository;

    public CourseEnrollment addCourseEnrollment(CourseEnrollment courseEnrollment) {
        return courseEnrollmentRepository.save(courseEnrollment);
    }

    public List<CourseEnrollment> getEnrollments() {
        return courseEnrollmentRepository.findAll();
    }
}
