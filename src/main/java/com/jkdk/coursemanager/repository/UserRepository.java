package com.jkdk.coursemanager.repository;

import com.jkdk.coursemanager.model.Role;
import com.jkdk.coursemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByType(Role role);

    Optional<User> findByLogin(String login);


}
