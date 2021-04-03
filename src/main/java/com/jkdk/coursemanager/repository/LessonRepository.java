package com.jkdk.coursemanager.repository;

import com.jkdk.coursemanager.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
