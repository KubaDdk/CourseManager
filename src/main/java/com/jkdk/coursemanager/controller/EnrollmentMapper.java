package com.jkdk.coursemanager.controller;

import com.jkdk.coursemanager.controller.dto.CourseEnrollmentDto;
import com.jkdk.coursemanager.model.CourseEnrollment;

import java.util.List;
import java.util.stream.Collectors;

public class EnrollmentMapper {

    public static CourseEnrollmentDto mapEnrollmentToDto(CourseEnrollment enrollment) {
        return CourseEnrollmentDto.builder()
                .id(enrollment.getId())
                .date(enrollment.getDate())
                .participantId(enrollment.getParticipant().getId())
                .courseId(enrollment.getCourse().getId())
                .build();
    }

    public static List<CourseEnrollmentDto> mepEnrollmentToDtoList(List<CourseEnrollment> enrollments) {
        return enrollments.stream()
                .map(EnrollmentMapper::mapEnrollmentToDto)
                .collect(Collectors.toList());
    }


}
