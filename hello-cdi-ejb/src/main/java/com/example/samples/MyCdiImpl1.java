package com.example.samples;

import javax.inject.Named;

@Named("myCdiImpl1")
public class MyCdiImpl1 implements MyCdi {

    @Override
    public String hello() {
        return "Hello MyCdiImpl1";
    }

}
