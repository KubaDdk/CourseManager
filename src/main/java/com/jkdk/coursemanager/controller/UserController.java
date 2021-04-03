package com.jkdk.coursemanager.controller;

import com.jkdk.coursemanager.controller.dto.UserDto;
import com.jkdk.coursemanager.exceptions.NotFoundException;
import com.jkdk.coursemanager.model.Role;
import com.jkdk.coursemanager.model.User;
import com.jkdk.coursemanager.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return UserDtoMapper.mapToUserDtos(userService.getUsers());
    }

    @GetMapping(value = "/users", params = "type")
    public List<UserDto> getUsersByType(@RequestParam("type") String type) {
        Role role = Role.valueOf(type);
        return UserDtoMapper.mapToUserDtos(userService.getUserByType(role));
    }

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable long id) throws NotFoundException {

        return UserDtoMapper.mapToUserDto(userService.getUserById(id));
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
