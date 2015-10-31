package com.example.samples;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named("myCdiImpl1")
@Dependent
public class MyCdiImpl1 implements MyCdi {

    @Override
    public String hello() {

        return "Hello MyCdiImpl1";
    }

}
