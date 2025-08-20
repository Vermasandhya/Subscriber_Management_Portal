package com.subscriber.subscriptionsauditservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "subscription_audit")
public class SubscriptionAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    @Column(nullable = false)
    private Long subscriptionId;

    @Column(nullable = false)
    private String action; // ACTIVATED, SUSPENDED, UPGRADED, CANCELLED, PAYMENT, etc.

    private Long oldPlanId;
    private Long newPlanId;
    private Long performedBy; // userId or adminId

    @Column(nullable = false)
    private LocalDateTime actionDate = LocalDateTime.now();

    @Column(length = 1000)
    private String remarks;

    // --- Getters & Setters ---
    public Long getAuditId() { return auditId; }
    public void setAuditId(Long auditId) { this.auditId = auditId; }

    public Long getSubscriptionId() { return subscriptionId; }
    public void setSubscriptionId(Long subscriptionId) { this.subscriptionId = subscriptionId; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public Long getOldPlanId() { return oldPlanId; }
    public void setOldPlanId(Long oldPlanId) { this.oldPlanId = oldPlanId; }

    public Long getNewPlanId() { return newPlanId; }
    public void setNewPlanId(Long newPlanId) { this.newPlanId = newPlanId; }

    public Long getPerformedBy() { return performedBy; }
    public void setPerformedBy(Long performedBy) { this.performedBy = performedBy; }

    public LocalDateTime getActionDate() { return actionDate; }
    public void setActionDate(LocalDateTime actionDate) { this.actionDate = actionDate; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
