package com.jkdk.coursemanager.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany
    private List<LessonBlock> lessonBlocks;

}
