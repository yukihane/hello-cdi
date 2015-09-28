package com.example.samples.intercept;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;


public class MyInterceptor {
    
    @AroundInvoke
    public Object intercept(final InvocationContext ctx) throws Exception {
        System.out.println("intercept!!!");
        return ctx.proceed();
    }

}
