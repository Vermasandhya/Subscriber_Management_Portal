package com.example.billing.model;

import jakarta.persistence.*;

@Entity
@Table(name = "billing")
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long subscriberId;
    private Long planId;
    private double amount;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getSubscriberId() { return subscriberId; }
    public void setSubscriberId(Long subscriberId) { this.subscriberId = subscriberId; }
    public Long getPlanId() { return planId; }
    public void setPlanId(Long planId) { this.planId = planId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
