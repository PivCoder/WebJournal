package com.example.Repositoryes;

import com.example.model.Authorization;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepository  extends JpaRepository<Authorization, Long> {
    Authorization findByUsername(String username);
}
