package com.subscriber.paymentservice.service;

import com.subscriber.paymentservice.entity.Payment;
import java.util.List;

public interface PaymentService {
    Payment createPayment(Payment payment);
    Payment getPaymentById(Long id);
    List<Payment> getPaymentsBySubscription(Long subscriptionId);
    List<Payment> getPaymentsByUser(Long userId);
    List<Payment> getAllPayments();
    Payment updateStatus(Long id, String newStatus, String notes);
}
