package com.example.Service.Implements;

import com.example.Repositoryes.AuthorizationRepository;
import com.example.Service.AuthorizationService;
import com.example.model.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorizationServiceImplement implements AuthorizationService {

    @Autowired
    AuthorizationRepository authorizationRepository;

    @Override
    public Authorization addAuthorization(Authorization authorization) {
        Authorization savedAuthorization = authorizationRepository.saveAndFlush(authorization);
        return savedAuthorization;
    }

    @Override
    public void deleteAuthorization(long id) {
        authorizationRepository.deleteById(id);
    }

    @Override
    public Optional<Authorization> getAuthorizationById(long id) {
        return authorizationRepository.findById(id);
    }

    @Override
    public Authorization editAuthorization(Authorization authorization) {
        return authorizationRepository.saveAndFlush(authorization);
    }

    @Override
    public List<Authorization> getAllAuthorizations() {
        return authorizationRepository.findAll();
    }
}
