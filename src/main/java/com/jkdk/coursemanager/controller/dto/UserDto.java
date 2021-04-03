package com.jkdk.coursemanager.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class UserDto {

    private long id;
    private String login;
    private String name;
    private String type;
}
