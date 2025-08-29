package com.example.User.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary
public class EmailNotificationService implements NotificationService{
    @Value("${Email.host:localhost}")
    private String host;

    @Value("${Email.port:3000}")
    private int port;
    @Override
    public void send(String message, String recipientEmail) {
        System.out.println(message + " to " + recipientEmail);
        System.out.println("Notification sent. Host: " + host + " Port: " + port);
    }
}
