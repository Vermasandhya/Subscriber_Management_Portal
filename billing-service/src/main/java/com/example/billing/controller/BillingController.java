package com.example.billing.controller;

import com.example.billing.model.Billing;
import com.example.billing.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping
    public List<Billing> getAllBilling() {
        return billingService.getAllBilling();
    }

    @GetMapping("/{id}")
    public Billing getBilling(@PathVariable Long id) {
        return billingService.getBillingById(id);
    }

    @PostMapping
    public Billing createBilling(@RequestBody Billing billing) {
        return billingService.createBilling(billing);
    }

    @PutMapping("/{id}")
    public Billing updateBilling(@PathVariable Long id, @RequestBody Billing billing) {
        return billingService.updateBilling(id, billing);
    }

    @DeleteMapping("/{id}")
    public void deleteBilling(@PathVariable Long id) {
        billingService.deleteBilling(id);
    }
}
