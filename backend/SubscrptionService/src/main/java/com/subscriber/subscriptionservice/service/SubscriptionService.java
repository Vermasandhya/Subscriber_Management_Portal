package com.subscriber.subscriptionservice.service;

import com.subscriber.subscriptionservice.entity.Subscription;
import java.util.List;

public interface SubscriptionService {

    Subscription createSubscription(Subscription subscription);

    Subscription getSubscriptionById(Long id);

    List<Subscription> getAllSubscriptions();

    List<Subscription> getSubscriptionsByUser(Long userId);

    Subscription updateSubscription(Long id, Subscription subscriptionDetails);

    void deleteSubscription(Long id);
}

