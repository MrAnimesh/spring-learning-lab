package com.learning.ioccontainer.scopes;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope // One bean instance is created for each HTTP request.
public class RequestScopeInfo {

    public RequestScopeInfo(){
        System.out.println("RequestInfo: "+this);
    }
}
