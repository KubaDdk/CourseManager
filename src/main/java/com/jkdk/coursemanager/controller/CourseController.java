package com.jkdk.coursemanager.controller;

import com.jkdk.coursemanager.controller.dto.CourseDetailsDto;
import com.jkdk.coursemanager.controller.dto.CourseDto;
import com.jkdk.coursemanager.controller.dto.CourseEnrollmentForm;
import com.jkdk.coursemanager.exceptions.NotFoundException;
import com.jkdk.coursemanager.model.Course;
import com.jkdk.coursemanager.model.CourseEnrollment;
import com.jkdk.coursemanager.model.User;
import com.jkdk.coursemanager.service.CourseEnrollmentService;
import com.jkdk.coursemanager.service.CourseService;
import com.jkdk.coursemanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;
    private final UserService userService;
    private final CourseEnrollmentService courseEnrollmentService;

    @GetMapping("/courses")
    public List<CourseDto> getAllCourses() {
        return CourseMapper.mapCourseToDtoList(courseService.getCourses());
    }

    @GetMapping("/courses/{id}")
    public CourseDetailsDto getSingleCourse(@PathVariable long id) throws NotFoundException {
        Course course = courseService.findById(id);
        return CourseMapper.mapCourseToDetailsDto(course);
    }


}
