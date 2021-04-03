package com.jkdk.coursemanager.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
public class CourseEnrollment {

    @Id
    @GeneratedValue
    private long id;
    private LocalDate date;
    @ManyToOne
    private User participant;
    @ManyToOne
    private Course course;
}
