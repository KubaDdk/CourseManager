package com.jkdk.coursemanager.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseEnrollmentForm {

    private long courseId;
    private long participantId;

}
