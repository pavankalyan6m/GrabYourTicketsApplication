package com.project.GrabYourTickets.Repositories;

import com.project.GrabYourTickets.Entity.Admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
}
