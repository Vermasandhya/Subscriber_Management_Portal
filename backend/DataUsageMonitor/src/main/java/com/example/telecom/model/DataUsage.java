package com.example.telecom.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DataUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String deviceType;
    private double dataUsedInMB;
    private LocalDate usageDate;
    private String networkType;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public double getDataUsedInMB() {
        return dataUsedInMB;
    }

    public void setDataUsedInMB(double dataUsedInMB) {
        this.dataUsedInMB = dataUsedInMB;
    }

    public LocalDate getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(LocalDate usageDate) {
        this.usageDate = usageDate;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }
}
