package com.example.samples.intercept;

import javax.ejb.Local;

@Local
public interface MyBeanLocal {

    String hello();
}
