package com.subscriber.subscriptionsauditservice.repository;

import com.subscriber.subscriptionsauditservice.entity.SubscriptionAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubscriptionAuditRepository extends JpaRepository<SubscriptionAudit, Long> {
    List<SubscriptionAudit> findBySubscriptionId(Long subscriptionId);
    List<SubscriptionAudit> findByPerformedBy(Long performedBy);
    List<SubscriptionAudit> findByAction(String action);
}
