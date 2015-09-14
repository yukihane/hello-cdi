package com.example.samples;

import javax.inject.Named;

@Named("myCdiImpl2")
public class MyCdiImpl2 implements MyCdi {

    @Override
    public String hello() {
        return "Hello MyCdiImpl2";
    }

}
