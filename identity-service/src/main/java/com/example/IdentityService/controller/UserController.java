package com.example.IdentityService.controller;

import com.example.IdentityService.dtos.LoginRequest;
import com.example.IdentityService.dtos.RegisterRequest;
import com.example.IdentityService.dtos.UserDto;
import com.example.IdentityService.service.AuthenticationService;
import com.example.IdentityService.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUsers(HttpServletRequest request) {
        List<UserDto> users = authenticationService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}
