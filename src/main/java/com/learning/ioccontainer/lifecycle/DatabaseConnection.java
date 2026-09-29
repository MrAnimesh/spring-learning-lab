package com.learning.ioccontainer.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnection {

    private final DatabaseClient databaseClient;

    public DatabaseConnection(DatabaseClient databaseClient) {
        System.out.println(
                "B. DatabaseConnection constructor"
        );

        this.databaseClient = databaseClient;
    }

    @PostConstruct
    public void initialize() {
        System.out.println(
                "C. DatabaseConnection @PostConstruct"
        );

        System.out.println(
                "Dependency available: "
                        + (databaseClient != null)
        );
    }

    @PreDestroy
    public void destroy() {
        System.out.println(
                "D. DatabaseConnection @PreDestroy"
        );
    }
}
