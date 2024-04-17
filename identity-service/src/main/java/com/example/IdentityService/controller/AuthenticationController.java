package com.example.IdentityService.controller;

import com.example.IdentityService.dtos.AlterProfile;
import com.example.IdentityService.dtos.LoginRequest;
import com.example.IdentityService.dtos.RegisterRequest;
import com.example.IdentityService.service.AuthenticationService;
import com.example.IdentityService.service.ProfileService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ProfileService profileService;



    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request
    ) {
        try
        {
            return ResponseEntity.ok(authenticationService.register(request));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request
    ) {
        try
        {
            return ResponseEntity.ok(authenticationService.login(request));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.LOCKED).body(e.getMessage());
        }
    }



   /* @GetMapping("/api/auth/profile")
    public ResponseEntity<AlterProfile> getProfile(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7); // Extract token after "Bearer "
            // Validate the token (e.g., using a JWT library)
            // ... your logic to retrieve profile based on user in token
        } else {
            // Handle missing or invalid token
        }
        AlterProfile profile = new AlterProfile();

        profile.setFirstName("Boban");
        profile.setLastName("Zloban");
        return ResponseEntity.ok(profile); // Replace with your logic to get profile
    }*/

    @GetMapping("/api/auth/profile")
    public ResponseEntity<AlterProfile> getProfile(@RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7); // Extract token after "Bearer "
            // Validate the token (e.g., using a JWT library)
            // ... your logic to retrieve profile based on user in token
        } else {
            // Handle missing or invalid token
        }

        AlterProfile profile = new AlterProfile();

        profile.setFirstName("Boban");
        profile.setLastName("Zloban");
        return ResponseEntity.ok(profile); // Replace with your logic to get profile
    }

}
