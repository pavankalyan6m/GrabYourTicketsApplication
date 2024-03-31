package com.project.GrabYourTickets.Controllers;

import com.project.GrabYourTickets.Entity.Admin.Admin;
import com.project.GrabYourTickets.Repositories.AdminRepository;
import com.project.GrabYourTickets.Services.Authentication.AdminAuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
public class AdminCreateController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminAuthenticationService authenticationService;
    private static final Logger log = LoggerFactory.getLogger(AdminCreateController.class);
    @PostMapping("/admin/create")
    public String createAdmin(@RequestParam("name") String name,
                              @RequestParam("email") String email,
                              @RequestParam("password") String password) {
        // Process the form data and save the admin
        // Create Admin object
        Admin admin = new Admin();
        admin.setName(name);
        admin.setEmail(email);
        admin.setPassword(password);
        // Set other fields similarly

        // Save the admin to repository
        adminRepository.save(admin);

        log.info("Inside admin-create Controller, creating new Admin with the provided response...");
        adminRepository.save(admin);
        return "Admin created successfully";
    }

    @PostMapping("/admin/authenticate")
    public ResponseEntity<String> login(@RequestBody AdminLoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        log.info("Attempting to authenticate admin with username: {}", username);
        Optional<Admin> adminCredentials = authenticationService.authenticate(username);

        if (adminCredentials.isPresent()) {
            Admin admin = adminCredentials.get();
            if (password.equals(admin.getPassword())) {
                // Redirect to another HTML page
                return ResponseEntity.status(HttpStatus.FOUND)
                        .header("Location", "/admin/admin-success.html")
                        .body("Login successful. Redirecting...");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // DTO class for login request
    static class AdminLoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
