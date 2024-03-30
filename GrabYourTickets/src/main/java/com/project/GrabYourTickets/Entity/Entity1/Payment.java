package com.project.GrabYourTickets.Entity.Entity1;

import com.project.GrabYourTickets.Entity.Booking;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Booking booking;

    private BigDecimal amount;
    private LocalDateTime paymentDateTime;
    private PaymentStatus status;

    // Getters and setters

    public Payment(Long id, Booking booking, BigDecimal amount, LocalDateTime paymentDateTime, PaymentStatus status) {
        this.id = id;
        this.booking = booking;
        this.amount = amount;
        this.paymentDateTime = paymentDateTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Payment() {
    }
}
