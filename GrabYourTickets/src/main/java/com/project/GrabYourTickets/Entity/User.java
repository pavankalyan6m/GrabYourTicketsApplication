package com.project.GrabYourTickets.Entity;

import com.project.GrabYourTickets.Entity.Entity1.ContactInfo;
import com.project.GrabYourTickets.Entity.Entity1.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;


    @Embedded
    private ContactInfo contactInfo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String phone, String address)
    {
        contactInfo.setPhone(phone);
        contactInfo.setAddress(address);
    }


    public User(Long id, String username, String email, String password, UserRole role, ContactInfo contactInfo) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.contactInfo = contactInfo;
    }
// Getters and setters

    public User() {
    }
}
