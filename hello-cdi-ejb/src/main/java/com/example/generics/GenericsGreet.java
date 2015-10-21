package com.example.generics;

import javax.ejb.Stateless;

@Stateless
public class GenericsGreet extends AbstractStringGreet implements MyGenerics<String> {

    @Override
    public String hello() {
        return "hello";
    }

}
