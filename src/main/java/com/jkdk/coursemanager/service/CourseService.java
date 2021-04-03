package com.jkdk.coursemanager.service;

import com.jkdk.coursemanager.exceptions.NotFoundException;
import com.jkdk.coursemanager.model.Course;
import com.jkdk.coursemanager.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course findById(Long id) throws NotFoundException {
        return courseRepository.findById(id).orElseThrow(() -> new NotFoundException("Course not found"));
    }
}
