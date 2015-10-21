package com.example.bridge_persist;

import javax.ejb.Local;

import com.example.entity.Person;

@Local
public interface BridgePersist {
    
    long persist();
    
    Person queryLazy(long id);

}
