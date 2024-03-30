package com.project.GrabYourTickets.Entity.Entity1;

import com.project.GrabYourTickets.Entity.Cinema;
import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cinema cinema;

    private String seatNumber;
    private boolean isBooked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public Seat() {
    }

    public Seat(Long id, Cinema cinema, String seatNumber, boolean isBooked) {
        this.id = id;
        this.cinema = cinema;
        this.seatNumber = seatNumber;
        this.isBooked = isBooked;
    }
// Getters and setters
}
