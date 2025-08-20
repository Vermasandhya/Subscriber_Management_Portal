package com.example.telecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.telecom.model.DataUsage;
import com.example.telecom.service.DataUsageService;

@RestController
@RequestMapping("/usage")
public class DataUsageController {

    @Autowired
    private DataUsageService service;

    @PostMapping
    public DataUsage createUsage(@RequestBody DataUsage usage) {
        return service.save(usage);
    }

    @GetMapping
    public List<DataUsage> getAllUsage() {
        return service.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<DataUsage> getUsageByUser(@PathVariable String userId) {
        return service.findByUserId(userId);
    }

    @GetMapping("/device/{deviceType}")
    public List<DataUsage> getUsageByDevice(@PathVariable String deviceType) {
        return service.findByDeviceType(deviceType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataUsage> updateUsage(@PathVariable Long id, @RequestBody DataUsage updated) {
        return service.findById(id).map(existing -> {
            existing.setUserId(updated.getUserId());
            existing.setDeviceType(updated.getDeviceType());
            existing.setDataUsedInMB(updated.getDataUsedInMB());
            existing.setUsageDate(updated.getUsageDate());
            existing.setNetworkType(updated.getNetworkType());
            return ResponseEntity.ok(service.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsage(@PathVariable Long id) {
        if (service.existsById(id)) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
