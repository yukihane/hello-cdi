package com.example.samples.intercept;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 * Session Bean implementation class MyBean
 */
@Stateless
@LocalBean
public class MyBean implements MyBeanLocal {

    /**
     * Default constructor. 
     */
    public MyBean() {
        // TODO Auto-generated constructor stub
    }

    @Interceptors(MyInterceptor.class)
    @Override
    public String hello() {
        return "Hello, MyBean.";
    }

}
