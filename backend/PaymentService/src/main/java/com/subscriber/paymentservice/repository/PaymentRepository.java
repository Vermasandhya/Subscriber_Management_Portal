package com.subscriber.paymentservice.repository;

import com.subscriber.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findBySubscriptionId(Long subscriptionId);
    List<Payment> findByUserId(Long userId);
}
