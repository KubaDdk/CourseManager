package com.jkdk.coursemanager.controller;

import com.jkdk.coursemanager.controller.dto.CourseEnrollmentDto;
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
public class EnrollmentController {

    private final CourseService courseService;
    private final UserService userService;
    private final CourseEnrollmentService courseEnrollmentService;

    @GetMapping("/enrollments")
    public List<CourseEnrollmentDto> getEnrollment() {
        return EnrollmentMapper.mepEnrollmentToDtoList(courseEnrollmentService.getEnrollments());
    }

    @PostMapping("/enrollments")
    public CourseEnrollment enrollParticipant(@RequestBody CourseEnrollmentForm newEnrollment) throws NotFoundException {
        Course course = courseService.findById(newEnrollment.getCourseId());
        User participant = userService.getUserById(newEnrollment.getParticipantId());

        CourseEnrollment enrollment = new CourseEnrollment();
        enrollment.setCourse(course);
        enrollment.setParticipant(participant);
        CourseEnrollment savedEnrollment = courseEnrollmentService.addCourseEnrollment(enrollment);

        return savedEnrollment;
    }


}
