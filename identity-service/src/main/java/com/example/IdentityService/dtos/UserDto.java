package com.example.IdentityService.dtos;
import com.example.IdentityService.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private String lastName;
    private String username;
    private LocalDate dateOfBirth;
    private String role;
}
