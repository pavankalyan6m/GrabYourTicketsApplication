package com.project.GrabYourTickets.Controllers;

import com.project.GrabYourTickets.Entity.Booking;
import com.project.GrabYourTickets.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(booking);
    }

    @PostMapping("/start-booking")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking bookingDto) {
        Booking createdBooking = bookingService.createBooking(bookingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long bookingId, @RequestBody Booking bookingDto) {
        Booking updatedBooking = bookingService.updateBooking(bookingId, bookingDto);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.noContent().build();
    }
}
