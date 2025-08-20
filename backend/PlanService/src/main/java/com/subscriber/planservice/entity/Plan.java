package com.subscriber.planservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @Column(nullable = false)
    private String planName;

    @Column(nullable = false)
    private String planType; // PREPAID or POSTPAID

    @Column(nullable = false)
    private double price;

    private double dataLimitGb; // e.g., 50 GB
    private int validityDays; // e.g., 28 days

    // --- Getters & Setters ---
    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDataLimitGb() {
        return dataLimitGb;
    }

    public void setDataLimitGb(double dataLimitGb) {
        this.dataLimitGb = dataLimitGb;
    }

    public int getValidityDays() {
        return validityDays;
    }

    public void setValidityDays(int validityDays) {
        this.validityDays = validityDays;
    }
}
