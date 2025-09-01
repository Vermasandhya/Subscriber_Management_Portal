package com.example.subscriber.controller;

import com.example.subscriber.model.Subscriber;
import com.example.subscriber.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscribers")
public class SubscriberController {

    @Autowired
    private SubscriberService subscriberService;

    @GetMapping
    public List<Subscriber> getAllSubscribers() {
        return subscriberService.getAllSubscribers();
    }

    @GetMapping("/{id}")
    public Subscriber getSubscriber(@PathVariable Long id) {
        return subscriberService.getSubscriberById(id);
    }

    @PostMapping
    public Subscriber createSubscriber(@RequestBody Subscriber subscriber) {
        return subscriberService.createSubscriber(subscriber);
    }

    @PutMapping("/{id}")
    public Subscriber updateSubscriber(@PathVariable Long id, @RequestBody Subscriber subscriber) {
        return subscriberService.updateSubscriber(id, subscriber);
    }

    @DeleteMapping("/{id}")
    public void deleteSubscriber(@PathVariable Long id) {
        subscriberService.deleteSubscriber(id);
    }
}

