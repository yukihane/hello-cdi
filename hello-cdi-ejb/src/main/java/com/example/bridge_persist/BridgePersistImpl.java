package com.example.bridge_persist;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.entity.Fruit;
import com.example.entity.Person;

@Stateless
public class BridgePersistImpl implements BridgePersist {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long persist() {
        Person p = new Person();
        p.setName("person");
        p.setAge(10);
        Fruit f = new Fruit();
        f.setName("fruit1");
        Fruit f2 = new Fruit();
        f2.setName("fruit2");

        p.addFruit(f);
        p.addFruit(f2);

        entityManager.persist(f);
        entityManager.persist(f2);
        entityManager.persist(p);

        return p.getId();
    }

    @Override
    public Person queryLazy(long id) {
        return entityManager.find(Person.class, id);
    }

}
