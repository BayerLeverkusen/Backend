package com.example.IdentityService.service;

import com.example.IdentityService.dtos.AlterProfile;
import com.example.IdentityService.model.User;
import com.example.IdentityService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public User getCurrentUser() {
        Authentication authenticationToken = SecurityContextHolder.getContext().getAuthentication();
        return (User)authenticationToken.getPrincipal();
    }

    public AlterProfile getValues() throws Exception{

        AlterProfile alterProfile = new AlterProfile();
        User user = getCurrentUser();

        alterProfile.setFirstName(user.getName());
        alterProfile.setLastName(user.getLastName());

        return  alterProfile;
    }
}
