package com.jkdk.coursemanager.controller;

import com.jkdk.coursemanager.controller.dto.CourseDetailsDto;
import com.jkdk.coursemanager.controller.dto.CourseDto;
import com.jkdk.coursemanager.model.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {

    private CourseMapper() {
    }

    public static CourseDto mapCourseToDto(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .name(course.getName())
                .courseLength(course.getLessonBlocks().stream()
                .mapToInt(block -> block.getLessons().size() * 8)
                .sum())
                .build();
    }

    public static List<CourseDto> mapCourseToDtoList(List<Course> courses) {
        return courses.stream()
                .map(CourseMapper::mapCourseToDto)
                .collect(Collectors.toList());
    }

    public static CourseDetailsDto mapCourseToDetailsDto(Course course) {
        return CourseDetailsDto.builder()
                .id(course.getId())
                .name(course.getName())
                .lessonBlocks(LessonMapper.mapLessonBlockToDtoList(course.getLessonBlocks()))
                .build();
    }

}
