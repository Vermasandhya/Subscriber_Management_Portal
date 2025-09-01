package com.example.subscriber.service;

import com.example.subscriber.model.Subscriber;
import com.example.subscriber.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    public List<Subscriber> getAllSubscribers() {
        return subscriberRepository.findAll();
    }

    public Subscriber getSubscriberById(Long id) {
        return subscriberRepository.findById(id).orElse(null);
    }

    public Subscriber createSubscriber(Subscriber subscriber) {
        return subscriberRepository.save(subscriber);
    }

    public Subscriber updateSubscriber(Long id, Subscriber subscriber) {
        Optional<Subscriber> existing = subscriberRepository.findById(id);
        if(existing.isPresent()) {
            Subscriber s = existing.get();
            s.setName(subscriber.getName());
            s.setEmail(subscriber.getEmail());
            return subscriberRepository.save(s);
        }
        return null;
    }

    public void deleteSubscriber(Long id) {
        subscriberRepository.deleteById(id);
    }
}
