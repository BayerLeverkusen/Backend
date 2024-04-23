package com.example.IdentityService.service;

import com.example.IdentityService.model.User;
import com.example.IdentityService.enums.UserRole;
import com.example.IdentityService.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InitialDataInsertionService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void insertInitialData(){
        LocalDate user1BirthDate = LocalDate.of(1981, 11, 25);
        User user1 = new User("Xabi", "Alonso", "XabiA", passwordEncoder.encode("leverkusen") , user1BirthDate, UserRole.HEAD_COACH);

        LocalDate user2BirthDate = LocalDate.of(2001, 12, 21);
        User user2 = new User("Uros", "Marihuanski", "Loha021", passwordEncoder.encode("loha123"), user2BirthDate, UserRole.EVENT_ORGANIZATOR);

        LocalDate user3BirthDate = LocalDate.of(1994,11,20);
        User user3 = new User("Admin", "Administrator", "NajjaciAdmin123", passwordEncoder.encode("admin"), user3BirthDate, UserRole.ADMIN);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }

    public boolean isInitialDataPresent(){
        return userRepository.existsByUsername("XabiA");
    }



}
