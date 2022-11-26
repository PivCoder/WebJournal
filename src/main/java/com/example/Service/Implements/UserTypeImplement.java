package com.example.Service.Implements;

import com.example.Repositoryes.UserTypeRepository;
import com.example.Service.UserTypeService;
import com.example.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTypeImplement implements UserTypeService {

    @Autowired
    UserTypeRepository userTypeRepository;

    @Override
    public UserType addUserType(UserType userType) {
        UserType savedUserType = userTypeRepository.saveAndFlush(userType);
        return savedUserType;
    }

    @Override
    public void deleteUserType(long id) {
        userTypeRepository.deleteById(id);
    }

    @Override
    public Optional<UserType> getUserTypeById(long id) {
        return userTypeRepository.findById(id);
    }

    @Override
    public UserType editUserType(UserType userType) {
        return userTypeRepository.saveAndFlush(userType);
    }

    @Override
    public List<UserType> getAllUserTypes() {
        return userTypeRepository.findAll();
    }
}
