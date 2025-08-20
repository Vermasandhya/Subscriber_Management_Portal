package com.example.telecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.telecom.model.DataUsage;

public interface DataUsageRepository extends JpaRepository<DataUsage, Long> {
    List<DataUsage> findByUserId(String userId);
    List<DataUsage> findByDeviceType(String deviceType);
}
