package com.example.samples.jpa;

import java.util.logging.Logger;

import javax.ejb.Stateless;

import com.example.entity.Person;

@Stateless
public class EntityPrinter {

    private static final Logger LOGGER = Logger.getLogger(EntityPrinter.class.getName());

    public void print(Person entity) {
        LOGGER.info("entity: " + entity);
    }
}
