package com.jkdk.coursemanager.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue
    private long id;
    private String subject;
    private LocalDate date;
}
