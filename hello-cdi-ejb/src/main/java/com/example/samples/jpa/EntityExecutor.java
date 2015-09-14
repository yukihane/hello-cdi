package com.example.samples.jpa;

import javax.inject.Inject;

import com.example.entity.Person;

public class EntityExecutor {

    @Inject
    private EntitySet entitySet;

    @Inject
    private EntityGet entityGet;

    public void execute() {
        long id = entitySet.set();

        Person res = entityGet.get(id);
        System.out.println(res);
        System.out.println(res.getFruits().iterator().next());

    }

}
