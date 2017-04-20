/*
 * Created: 2016/07/19 dewa
 * Copyright (c) 2016, NS Solutions Corporation, All rights reserved.
 */

package com.example.samples;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int age;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age
     *            the age to set
     */
    public void setAge(final int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
