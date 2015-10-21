package com.example.generics;

import javax.ejb.Local;

@Local
public interface MyGenerics<T> {
    T hello();
}
