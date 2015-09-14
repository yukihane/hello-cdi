package com.example.samples.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.entity.Fruit;
import com.example.entity.Person;

@Stateless
public class EntitySet {

    @PersistenceContext
    private EntityManager em;

    public long set() {
        Fruit f1 = new Fruit();
        f1.setName("fruit1");

        Fruit f2 = new Fruit();
        f2.setName("fruit2");

        Person p = new Person();
        p.setName("myname");
        p.setAge(10);
        p.addFruit(f1);
        p.addFruit(f2);

        em.persist(p);

        return p.getId();
    }
}
