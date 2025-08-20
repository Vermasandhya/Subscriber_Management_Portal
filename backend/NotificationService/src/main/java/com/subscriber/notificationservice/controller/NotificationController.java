package com.subscriber.notificationservice.controller;

import com.subscriber.notificationservice.model.Notification;
import com.subscriber.notificationservice.service.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public Notification send(@RequestBody Notification notification) {
        return service.sendNotification(notification);
    }

    @GetMapping
    public List<Notification> getAll() {
        return service.getAllNotifications();
    }
}
