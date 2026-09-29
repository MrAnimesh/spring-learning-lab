package com.learning.ioccontainer.scopes;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope //One bean instance per HTTP session.
public class UserSession {

    public UserSession() {
        System.out.println(
                "UserSession created: " + this
        );
    }
}