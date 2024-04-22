package com.example.IdentityService.service;

import com.example.IdentityService.dtos.LoginRequest;
import com.example.IdentityService.dtos.AuthenticationResponse;
import com.example.IdentityService.dtos.RegisterRequest;
import com.example.IdentityService.dtos.UserDto;
import com.example.IdentityService.model.User;
import com.example.IdentityService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) throws Exception {
        if(userRepository.existsByUsername(request.getUsername())){
            throw new Exception("User with the provided username already exists!");
        }
        if(request.getUsername() == null || request.getLastName() == null || request.getFirstName() == null || request.getRole() == null || request.getPassword() == null || request.getDateOfBirth() == null){
            throw new Exception("Please fill all the fields in order to proceed");
        }
        User user = User.builder()
                .name(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .dateOfBirth(request.getDateOfBirth())
                .build();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse login(LoginRequest request) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new Exception("User with that username not found."));
//        if(!passwordEncoder.encode(request.getPassword()).equals(user.getPassword())){
//            throw new Exception("Invalid password.");
//        }
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

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
}
