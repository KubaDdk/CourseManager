package com.jkdk.coursemanager.service;

import com.jkdk.coursemanager.exceptions.NotFoundException;
import com.jkdk.coursemanager.model.LessonBlock;
import com.jkdk.coursemanager.repository.LessonBlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonBlockService {

    private final LessonBlockRepository lessonBlockRepository;

    public LessonBlock getBlockById(Long id) throws NotFoundException {
        return lessonBlockRepository.findById(id).orElseThrow(() -> new NotFoundException("Lesson block not found"));
    }

    public LessonBlock addLessonBlock(LessonBlock lessonBlock) {
        return lessonBlockRepository.save(lessonBlock);
    }
}
