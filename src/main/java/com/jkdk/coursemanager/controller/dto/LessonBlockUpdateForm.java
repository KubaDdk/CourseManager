package com.jkdk.coursemanager.controller.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class LessonBlockUpdateForm {

    @NotNull
    @NotBlank
    @Length(min = 4, max = 50)
    private String subject;

    @Min(1)
    private long teacherId;
}
