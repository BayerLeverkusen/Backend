package com.example.IdentityService.service;

import com.example.IdentityService.dtos.EditProfileRequest;
import com.example.IdentityService.dtos.UserDto;
import com.example.IdentityService.model.User;
import com.example.IdentityService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private UserDto convertToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .dateOfBirth(user.getDateOfBirth())
                .role(user.getRole().name())
                .build();
    }

    public void editUserProfile(EditProfileRequest request) throws Exception {
        if(!userRepository.findByUsername(request.getUsername()).isPresent()){
            throw new Exception("User not found");
        }

        User user = userRepository.findByUsername(request.getUsername()).get();

        if (request.getName() != null) {
            user.setName(request.getName());
        }
        if (request.getLastName() != null) {
            user.setLastName(request.getLastName());
        }
        if (request.getNewPassword() != null) {
            if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
                throw new Exception("Incorrect old password");
            }
            user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        }
        userRepository.save(user);
    }


}
