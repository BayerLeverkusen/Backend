package com.example.IdentityService.repository;

import com.example.IdentityService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User save(User user);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
