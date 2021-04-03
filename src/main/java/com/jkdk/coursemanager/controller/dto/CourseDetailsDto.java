package com.jkdk.coursemanager.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CourseDetailsDto {

    private long id;
    private String name;
    private List<LessonBlockDetailsDto> lessonBlocks;

}
