package com.learning.ioccontainer.scopes;

import org.apache.coyote.RequestInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
public class RequestScopeController {

    private final RequestScopeInfo requestInfo;
    private final UserSession userSession;

    public RequestScopeController(
            RequestScopeInfo requestInfo,
            UserSession userSession
    ) {
        this.requestInfo = requestInfo;
        this.userSession = userSession;
    }

    @GetMapping("/request")
    public String scope() {

        return """
                Request bean: %s
                Session bean: %s
                """.formatted(
                requestInfo,
                userSession
        );
    }
}
