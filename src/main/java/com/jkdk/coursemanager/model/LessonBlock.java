package com.jkdk.coursemanager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class LessonBlock {

    @Id
    @GeneratedValue
    private long id;
    private String subject;
    @OneToMany
    private List<Lesson> lessons;
    @ManyToOne
    private User teacher;

}
