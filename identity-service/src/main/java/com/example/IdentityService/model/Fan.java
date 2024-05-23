package com.example.IdentityService.model;

import com.example.IdentityService.enums.FanLevel;
import com.example.IdentityService.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fans")
public class Fan extends User {

    @Enumerated(EnumType.STRING)
    private FanLevel level;

    @Column
    private int balance;

    @Builder(builderMethodName = "fanBuilder")
    public Fan(String name, String lastName, String username, String password, LocalDate dateOfBirth, FanLevel level, int balance) {
        super(name, lastName, username, password, dateOfBirth, UserRole.FAN);
        this.level = level;
        this.balance = balance;
    }
}
