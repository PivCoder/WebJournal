package com.example.Service;

import com.example.model.Authorization;

import java.util.List;
import java.util.Optional;

public interface AuthorizationService {
    Authorization addAuthorization(Authorization authorization);
    void deleteAuthorization(long id);
    Optional<Authorization> getAuthorizationById(long id);
    Authorization editAuthorization(Authorization authorization);
    List<Authorization> getAllAuthorizations();
}
