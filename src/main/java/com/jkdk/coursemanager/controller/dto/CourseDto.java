package com.jkdk.coursemanager.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseDto {

    private long id;
    private String name;
    private int courseLength;
}
