package com.example.Service;

import com.example.model.UserType;

import java.util.List;
import java.util.Optional;

public interface UserTypeService {
    UserType addUserType(UserType userType);
    void deleteUserType(long id);
    Optional<UserType> getUserTypeById(long id);
    UserType editUserType(UserType userType);
    List<UserType> getAllUserTypes();
}
