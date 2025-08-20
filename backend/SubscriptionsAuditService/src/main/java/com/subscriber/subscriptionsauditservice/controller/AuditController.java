package com.subscriber.subscriptionsauditservice.controller;

import com.subscriber.subscriptionsauditservice.entity.SubscriptionAudit;
import com.subscriber.subscriptionsauditservice.service.AuditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditController {

    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    // Record an audit event
    @PostMapping
    public ResponseEntity<SubscriptionAudit> record(@RequestBody SubscriptionAudit audit) {
        SubscriptionAudit saved = auditService.record(audit);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionAudit> getById(@PathVariable Long id) {
        SubscriptionAudit a = auditService.getById(id);
        return (a != null) ? ResponseEntity.ok(a) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionAudit>> getAll() {
        return ResponseEntity.ok(auditService.getAll());
    }

    @GetMapping("/subscription/{subscriptionId}")
    public ResponseEntity<List<SubscriptionAudit>> bySubscription(@PathVariable Long subscriptionId) {
        return ResponseEntity.ok(auditService.getBySubscriptionId(subscriptionId));
    }

    @GetMapping("/performedBy/{performedBy}")
    public ResponseEntity<List<SubscriptionAudit>> byPerformedBy(@PathVariable Long performedBy) {
        return ResponseEntity.ok(auditService.getByPerformedBy(performedBy));
    }

    @GetMapping("/action/{action}")
    public ResponseEntity<List<SubscriptionAudit>> byAction(@PathVariable String action) {
        return ResponseEntity.ok(auditService.getByAction(action));
    }
}

