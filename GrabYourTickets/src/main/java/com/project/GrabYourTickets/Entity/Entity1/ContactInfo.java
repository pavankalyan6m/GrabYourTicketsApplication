package com.project.GrabYourTickets.Entity.Entity1;

import jakarta.persistence.*;

@Embeddable
public class ContactInfo {


    private String phone;

    private String address;

    public ContactInfo() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ContactInfo(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }
// Getters and setters
}
