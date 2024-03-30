package com.project.GrabYourTickets.Repositories;

import com.project.GrabYourTickets.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
}
