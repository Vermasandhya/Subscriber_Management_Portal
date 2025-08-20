package com.subscriber.subscriptionsauditservice.service;

import com.subscriber.subscriptionsauditservice.entity.SubscriptionAudit;
import java.util.List;

public interface AuditService {
    SubscriptionAudit record(SubscriptionAudit audit);
    SubscriptionAudit getById(Long id);
    List<SubscriptionAudit> getAll();
    List<SubscriptionAudit> getBySubscriptionId(Long subscriptionId);
    List<SubscriptionAudit> getByPerformedBy(Long performedBy);
    List<SubscriptionAudit> getByAction(String action);
}

