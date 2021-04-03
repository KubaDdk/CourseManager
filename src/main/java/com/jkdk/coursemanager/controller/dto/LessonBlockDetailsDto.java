package com.jkdk.coursemanager.controller.dto;

import com.jkdk.coursemanager.model.Lesson;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Builder
public class LessonBlockDetailsDto {
    private long id;
    private String subject;
    private List<Lesson> lessons;
    private String teacherName;
    private long teacherId;
}
