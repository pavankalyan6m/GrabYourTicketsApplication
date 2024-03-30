package com.project.GrabYourTickets.Services;

import com.project.GrabYourTickets.Entity.Booking;
import com.project.GrabYourTickets.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        return booking.orElse(null); // Return null if the booking is not found
    }

    public Booking createBooking(Booking bookingDto) {
        // You can add validation and additional logic here
        return bookingRepository.save(bookingDto);
    }

    public Booking updateBooking(Long bookingId, Booking bookingDto) {
        Optional<Booking> existingBooking = bookingRepository.findById(bookingId);

        if (existingBooking.isPresent()) {
            Booking booking = existingBooking.get();
            // Update booking attributes with data from bookingDto
            booking.setUser(bookingDto.getUser());
            booking.setShowtime(bookingDto.getShowtime());
            booking.setClassType(bookingDto.getClassType());
            booking.setNumTickets(bookingDto.getNumTickets());
            // Update other attributes as needed

            // Save the updated booking
            return bookingRepository.save(booking);
        } else {
            return null; // Booking not found
        }
    }

    public void deleteBooking(Long bookingId) {
        // You can add additional logic here, such as checking if the booking exists
        bookingRepository.deleteById(bookingId);
    }
}
