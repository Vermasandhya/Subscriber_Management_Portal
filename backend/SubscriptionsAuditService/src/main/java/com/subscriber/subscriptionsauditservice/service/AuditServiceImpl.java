package com.subscriber.subscriptionsauditservice.service;

import com.subscriber.subscriptionsauditservice.entity.SubscriptionAudit;
import com.subscriber.subscriptionsauditservice.repository.SubscriptionAuditRepository;
import com.subscriber.subscriptionsauditservice.service.AuditService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {

    private final SubscriptionAuditRepository repository;

    public AuditServiceImpl(SubscriptionAuditRepository repository) {
        this.repository = repository;
    }

    @Override
    public SubscriptionAudit record(SubscriptionAudit audit) {
        // Placeholder: you can add logic to send notifications here (email, websocket, etc.)
        // sendNotification(audit);
        return repository.save(audit);
    }

    @Override
    public SubscriptionAudit getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<SubscriptionAudit> getAll() {
        return repository.findAll();
    }

    @Override
    public List<SubscriptionAudit> getBySubscriptionId(Long subscriptionId) {
        return repository.findBySubscriptionId(subscriptionId);
    }

    @Override
    public List<SubscriptionAudit> getByPerformedBy(Long performedBy) {
        return repository.findByPerformedBy(performedBy);
    }

    @Override
    public List<SubscriptionAudit> getByAction(String action) {
        return repository.findByAction(action);
    }

    // Example placeholder method for notifications (implement mail/websocket later)
    /*
    private void sendNotification(SubscriptionAudit audit) {
        // e.g., call EmailService or push to message broker
    }
    */
}
