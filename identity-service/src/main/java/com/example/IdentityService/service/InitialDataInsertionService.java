package com.example.IdentityService.service;

import com.example.IdentityService.enums.FanLevel;
import com.example.IdentityService.enums.UserRole;
import com.example.IdentityService.model.Fan;
import com.example.IdentityService.model.User;
import com.example.IdentityService.repository.FanRepository;
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
    private FanRepository fanRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private void insertUserIfNotExists(String firstName, String lastName, String username, String password, LocalDate birthDate, UserRole role) {
        if (!userRepository.existsByUsername(username)) {
            User user = new User(firstName, lastName, username, passwordEncoder.encode(password), birthDate, role);
            userRepository.save(user);
        }
    }

    public void insertFanIfNotExists(String firstName, String lastName, String username, String password, LocalDate birthDate, FanLevel level, int balance) {
        if (!userRepository.existsByUsername(username)) {
            Fan fan = Fan.fanBuilder()
                    .name(firstName)
                    .lastName(lastName)
                    .username(username)
                    .password(passwordEncoder.encode(password))
                    .dateOfBirth(birthDate)
                    .level(level)
                    .balance(balance)
                    .build();
            fanRepository.save(fan);
        }
    }


    @Transactional
    public void insertInitialData() {
        // Insert new initial data
        insertUserIfNotExists("Xabi", "Alonso", "XabiA", "leverkusen", LocalDate.of(1981, 11, 25), UserRole.HEAD_COACH);
        insertUserIfNotExists("Uros", "Marihuanski", "Loha021", "loha123", LocalDate.of(2001, 12, 21), UserRole.EVENT_ORGANIZATOR);
        insertUserIfNotExists("Admin", "Administrator", "NajjaciAdmin123", "admin", LocalDate.of(1994, 11, 20), UserRole.ADMIN);
        insertUserIfNotExists("Aleksa", "Simeunovic", "marketing", "manager", LocalDate.of(1994, 11, 20), UserRole.SHOP_MANAGER);
        insertUserIfNotExists("Aleksa", "Lukac", "uprava", "uprava", LocalDate.of(1994, 11, 20), UserRole.DIRECTOR);
        insertUserIfNotExists("Igor", "Andjelkovic", "fan", "fan", LocalDate.of(1994, 11, 20), UserRole.FAN);

        // Insert new fans
        insertFanIfNotExists("Nemanja", "Todorovic", "nemanja", "todorovic", LocalDate.of(1990, 1, 1), FanLevel.BRONZE, 1000);
        insertFanIfNotExists("Andrej", "Anisic", "andrej", "anisic", LocalDate.of(1985, 5, 15), FanLevel.SILVER, 2000);
        insertFanIfNotExists("Vladimir", "Blanusa", "vladimir", "blanusa", LocalDate.of(1995, 8, 20), FanLevel.GOLD, 3000);
    }
}
