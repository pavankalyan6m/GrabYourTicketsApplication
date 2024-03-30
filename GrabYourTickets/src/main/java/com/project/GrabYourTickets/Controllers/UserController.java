package com.project.GrabYourTickets.Controllers;

import com.project.GrabYourTickets.Entity.User;
import com.project.GrabYourTickets.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Implement user registration logic here
        userService.registerUser(user);
        log.info("Inside /register method of UserController.");
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<User> getUserProfile(@PathVariable Long userId) {
        // Implement logic to retrieve and return user profile
        User userDto = userService.getUserProfile(userId);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUserProfile(@PathVariable Long userId, @RequestBody User userDto) {
        // Implement logic to update user profile
        userService.updateUserProfile(userId, userDto);
        return ResponseEntity.ok("User profile updated successfully");
    }
}
