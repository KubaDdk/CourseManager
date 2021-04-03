package com.jkdk.coursemanager.controller;


import com.jkdk.coursemanager.controller.dto.LessonBlockDetailsDto;
import com.jkdk.coursemanager.model.LessonBlock;
import com.jkdk.coursemanager.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LessonMapper {

    public static LessonBlockDetailsDto mapLessonBlockToDto(LessonBlock lessonBlock) {
        return LessonBlockDetailsDto.builder()
                .id(lessonBlock.getId())
                .subject(lessonBlock.getSubject())
                .lessons(new ArrayList<>(lessonBlock.getLessons()))
                .teacherId(getTeacherId(lessonBlock))
                .teacherName(getTeacherName(lessonBlock))
                .build();
    }

    public static List<LessonBlockDetailsDto> mapLessonBlockToDtoList(List<LessonBlock> blocks) {
        return blocks.stream()
                .map(LessonMapper::mapLessonBlockToDto)
                .collect(Collectors.toList());
    }

    private static long getTeacherId(LessonBlock block) {
        return Optional.ofNullable(block)
                .map(LessonBlock::getTeacher)
                .map(User::getId)
                .orElse(0L);
    }

    private static String getTeacherName(LessonBlock block) {
        return Optional.ofNullable(block)
                .map(LessonBlock::getTeacher)
                .map(u -> String.format("%s %s", u.getFirstName(), u.getLastName()))
                .orElse("");
    }
}
