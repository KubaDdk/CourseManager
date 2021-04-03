package com.jkdk.coursemanager.service;

import com.jkdk.coursemanager.exceptions.NotFoundException;
import com.jkdk.coursemanager.model.Role;
import lombok.RequiredArgsConstructor;
import com.jkdk.coursemanager.model.User;
import org.springframework.stereotype.Service;
import com.jkdk.coursemanager.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found"));
    }

    public User getUserByLogin(String login) throws NotFoundException {
        return userRepository.findByLogin(login).orElseThrow(() -> new NotFoundException("User Not Found"));
    }

    public List<User> getUserByType(Role role) {
        return userRepository.findByType(role);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User editUser(User user) throws NotFoundException {
        User userEdited = this.getUserById(user.getId());
        // TO DO: edit user Edited
        return userEdited;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
