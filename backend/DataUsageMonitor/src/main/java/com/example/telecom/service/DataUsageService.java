package com.example.telecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telecom.model.DataUsage;
import com.example.telecom.repository.DataUsageRepository;

@Service
public class DataUsageService {

    @Autowired
    private DataUsageRepository repository;

    public DataUsage save(DataUsage usage) {
        return repository.save(usage);
    }

    public List<DataUsage> findAll() {
        return repository.findAll();
    }

    public List<DataUsage> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public List<DataUsage> findByDeviceType(String deviceType) {
        return repository.findByDeviceType(deviceType);
    }

    public Optional<DataUsage> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
