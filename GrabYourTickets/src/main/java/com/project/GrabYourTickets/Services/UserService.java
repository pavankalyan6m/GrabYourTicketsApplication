package com.project.GrabYourTickets.Services;

import com.project.GrabYourTickets.Entity.User;
import com.project.GrabYourTickets.Repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // You can perform user registration logic here, e.g., validation, password hashing, etc.
        // Save the user to the database using the UserRepository.
        log.info("Inside registerUser method of UserService.");
        return userRepository.save(user);
    }

    public User getUserProfile(Long userId) {
        // Retrieve the user profile from the database using the UserRepository.
        return userRepository.findById(userId)
                .orElseThrow(() -> new ExpressionException("User not found with ID: " + userId));
    }

    public User updateUserProfile(Long userId, User userDto) {
        // Retrieve the user from the database using the UserRepository.
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ExpressionException("User not found with ID: " + userId));

        // Update the user's data with the information from the userDto.
        existingUser.setUsername(userDto.getUsername());
        existingUser.setEmail(userDto.getEmail());

        // You can continue updating other user attributes here.

        // Save the updated user back to the database using the UserRepository.
        return userRepository.save(existingUser);
    }
}

