package com.jkdk.coursemanager.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CourseEnrollmentDto {

    private long id;
    private LocalDate date;
    private long participantId;
    private long courseId;

}
