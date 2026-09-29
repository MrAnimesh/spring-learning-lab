package com.learning.ioccontainer.injection;

import org.springframework.stereotype.Service;

@Service
public class ConstructorInjectionService {

    private final NotificationService notificationService;

    public ConstructorInjectionService(
            NotificationService notificationService
    ) {
        this.notificationService = notificationService;
    }

    public void process() {
        System.out.println(
                "Constructor dependency = " + notificationService
        );

        notificationService.send();
    }
}
