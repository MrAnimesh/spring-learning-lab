package com.learning.ioccontainer.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldInjectionService {

    @Autowired
    private NotificationService notificationService;

    public FieldInjectionService(){
        System.out.println(
                "FieldInjectionService constructor"
        );

        System.out.println(
                "notificationService = "
                        + notificationService
        );
    }

    public void process() {
        System.out.println(
                "Field dependency = " + notificationService
        );

        notificationService.send();
    }
}