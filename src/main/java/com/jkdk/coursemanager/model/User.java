package com.jkdk.coursemanager.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String login;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role type;
    private String firstName;
    private String lastName;
    private boolean active;

}
