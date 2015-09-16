package com.example.samples.jpa;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.entity.Person;

@Stateless
public class EntityExecutor {

    @Inject
    private EntitySet entitySet;

    @Inject
    private EntityGet entityGet;

    @Inject
    private EntityPrinter entityPrinter;

    public void execute() {
        long id = entitySet.set();

        Person res = entityGet.get(id);

        entityPrinter.print(res);
    }

}
