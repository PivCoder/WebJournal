package com.example.Service;

import com.example.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    void deleteUser(long id);
    Optional<User> getUserById(long id);
    User editUser(User user);
    List<User> getAllUsers();
}
