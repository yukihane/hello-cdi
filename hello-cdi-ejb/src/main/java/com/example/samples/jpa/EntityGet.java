package com.example.samples.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.entity.Person;

@Stateless
public class EntityGet {

    @PersistenceContext
    private EntityManager em;

    public Person get(long id) {
        return em.find(Person.class, id);
    }

    public List <Person> getAll() {
        Query query = em.createQuery("SELECT p FROM Person p");
        return query.getResultList();
    }
}
