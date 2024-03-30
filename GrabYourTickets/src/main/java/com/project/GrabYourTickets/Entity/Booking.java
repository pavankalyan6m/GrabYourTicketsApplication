package com.project.GrabYourTickets.Entity;

import com.project.GrabYourTickets.Entity.Entity1.BookingStatus;
import com.project.GrabYourTickets.Entity.Entity1.ClassType;
import com.project.GrabYourTickets.Entity.Entity1.Showtime;
import jakarta.persistence.*;


@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Showtime showtime;

    @Enumerated(EnumType.STRING)
    private ClassType classType;

    private int numTickets;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    // Getters and setters

    public Booking(Long id, User user, Showtime showtime, ClassType classType, int numTickets, BookingStatus status) {
        this.id = id;
        this.user = user;
        this.showtime = showtime;
        this.classType = classType;
        this.numTickets = numTickets;
        this.status = status;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
