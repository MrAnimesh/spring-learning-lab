package com.learning.ioccontainer.injection;


import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void send() {
        System.out.println("Notification sent");
    }
}