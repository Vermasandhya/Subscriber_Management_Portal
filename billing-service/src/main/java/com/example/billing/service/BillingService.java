package com.example.billing.service;

import com.example.billing.model.Billing;
import com.example.billing.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public List<Billing> getAllBilling() {
        return billingRepository.findAll();
    }

    public Billing getBillingById(Long id) {
        return billingRepository.findById(id).orElse(null);
    }

    public Billing createBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    public Billing updateBilling(Long id, Billing billing) {
        Optional<Billing> existing = billingRepository.findById(id);
        if(existing.isPresent()) {
            Billing b = existing.get();
            b.setSubscriberId(billing.getSubscriberId());
            b.setPlanId(billing.getPlanId());
            b.setAmount(billing.getAmount());
            return billingRepository.save(b);
        }
        return null;
    }

    public void deleteBilling(Long id) {
        billingRepository.deleteById(id);
    }
}
