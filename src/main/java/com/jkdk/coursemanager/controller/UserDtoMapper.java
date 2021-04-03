package com.jkdk.coursemanager.controller;

import com.jkdk.coursemanager.controller.dto.UserDto;
import com.jkdk.coursemanager.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDtoMapper {
    private UserDtoMapper() {
    }

    public static List<UserDto> mapToUserDtos(List<User> users) {
        return users.stream()
                .map(UserDtoMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    public static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .name(String.format("%s %s", user.getFirstName(), user.getLastName()))
                .type(user.getType().name())
                .build();
    }
}
