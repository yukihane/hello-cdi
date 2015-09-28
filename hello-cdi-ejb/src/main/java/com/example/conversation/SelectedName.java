package com.example.conversation;

import java.io.Serializable;

import javax.enterprise.context.Dependent;

@Dependent
public class SelectedName implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public void set(String name) {
        this.name = name;
    }

    public String get() {
        return name;
    }
}
