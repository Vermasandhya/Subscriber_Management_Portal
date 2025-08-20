package com.subscriber.notificationservice.service;

import com.subscriber.notificationservice.model.Notification;
import com.subscriber.notificationservice.repository.NotificationRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public Notification sendNotification(Notification notification) {
        // here you can integrate Email/SMS API
        notification.setStatus(true);
        return repository.save(notification);
    }

	public List<Notification> getAllNotifications() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
}
