package com.learning.ioccontainer.lifecycle;

import org.springframework.stereotype.Component;

@Component
public class DatabaseClient {
    public DatabaseClient() {
        System.out.println(
                "A. DatabaseClient constructor"
        );
    }
}
