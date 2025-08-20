package com.subscriber.paymentservice.service;

import com.subscriber.paymentservice.entity.Payment;
import com.subscriber.paymentservice.repository.PaymentRepository;
import com.subscriber.paymentservice.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment createPayment(Payment payment) {
        // In a real integration, validate subscription via Subscription Service,
        // and verify amount against Plan Service. For now, just save.
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Payment> getPaymentsBySubscription(Long subscriptionId) {
        return paymentRepository.findBySubscriptionId(subscriptionId);
    }

    @Override
    public List<Payment> getPaymentsByUser(Long userId) {
        return paymentRepository.findByUserId(userId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment updateStatus(Long id, String newStatus, String notes) {
        Payment p = getPaymentById(id);
        if (p == null) return null;
        p.setStatus(newStatus);
        if (notes != null && !notes.isEmpty()) {
            p.setNotes(notes);
        }
        return paymentRepository.save(p);
    }
}
