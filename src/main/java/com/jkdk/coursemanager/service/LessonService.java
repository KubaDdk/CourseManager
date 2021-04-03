package com.jkdk.coursemanager.service;


import com.jkdk.coursemanager.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
}
