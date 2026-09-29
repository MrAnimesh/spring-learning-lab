package com.learning.ioccontainer.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeService {
    public PrototypeService() {
        System.out.println(
                ">>> PrototypeService created: " + this
        );
    }
}
