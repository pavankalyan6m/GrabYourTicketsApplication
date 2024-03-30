package com.project.GrabYourTickets.Services.Authentication;

import com.project.GrabYourTickets.Entity.Admin.Admin;
import com.project.GrabYourTickets.Repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// AuthenticationService.java
@Service
public class AdminAuthenticationService {
    @Autowired
    private AdminRepository adminRepository;
    public Optional<Admin> authenticate(String email) {
        Admin admin = adminRepository.findByEmail(email);
        return Optional.ofNullable(admin);
    }
}
