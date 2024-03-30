package com.project.GrabYourTickets.Entity;

import jakarta.persistence.*;

@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private City city;

    private String location;

    // Getters and setters

    public Cinema(Long id, String name, City city, String location) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.location = location;
    }

    public Cinema() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
