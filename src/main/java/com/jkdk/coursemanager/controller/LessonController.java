package com.jkdk.coursemanager.controller;

import com.jkdk.coursemanager.controller.dto.LessonBlockDetailsDto;
import com.jkdk.coursemanager.controller.dto.LessonBlockUpdateForm;
import com.jkdk.coursemanager.exceptions.NotFoundException;
import com.jkdk.coursemanager.model.LessonBlock;
import com.jkdk.coursemanager.model.User;
import com.jkdk.coursemanager.service.LessonBlockService;
import com.jkdk.coursemanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LessonController {

    private final LessonBlockService lessonBlockService;
    private final UserService userService;

    @GetMapping("/lessonblocks/{id}")
    public LessonBlockDetailsDto getSinleLessonBlock(@PathVariable long id) throws NotFoundException {
        LessonBlock lessonBlock = lessonBlockService.getBlockById(id);

        return LessonMapper.mapLessonBlockToDto(lessonBlock);
    }

    @PutMapping("/lessonblocks/{id}")
    public LessonBlockDetailsDto updateLessonBlock(@PathVariable Long id, @RequestBody LessonBlockUpdateForm newLessonBlock) throws NotFoundException {
        LessonBlock lessonBlock = lessonBlockService.getBlockById(id);
        lessonBlock.setSubject(newLessonBlock.getSubject());

        User teacher = userService.getUserById(newLessonBlock.getTeacherId());

        lessonBlock.setTeacher(teacher);

        LessonBlock updatedLessonBlock = lessonBlockService.addLessonBlock(lessonBlock);

        return LessonMapper.mapLessonBlockToDto(updatedLessonBlock);
    }

    @PutMapping("/lessonblocks/{id}/assignToMe")
    public LessonBlockDetailsDto updateLessonBlock(@PathVariable Long id, Principal principal) throws NotFoundException {
        LessonBlock lessonBlock = lessonBlockService.getBlockById(id);

        User teacher = userService.getUserByLogin(principal.getName());

        lessonBlock.setTeacher(teacher);
        LessonBlock updatedLessonBlock = lessonBlockService.addLessonBlock(lessonBlock);

        return LessonMapper.mapLessonBlockToDto(updatedLessonBlock);
    }
}
