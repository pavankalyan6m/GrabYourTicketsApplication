package com.project.GrabYourTickets.Entity.Entity1;

public enum UserRole {
    CUSTOMER("ROLE_CUSTOMER"),
    ADMINISTRATOR("ROLE_ADMIN");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
