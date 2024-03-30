package com.project.GrabYourTickets.Entity.Entity1;

import com.project.GrabYourTickets.Entity.Cinema;
import com.project.GrabYourTickets.Entity.Event;
import com.project.GrabYourTickets.Entity.Movie;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Event event;

    @ManyToOne
    private Cinema cinema;

    private LocalDateTime showDateTime;

    // Getters and setters
}
