package com.example.bridge_persist;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.example.entity.Person;

@Stateless
public class PersistEntryImpl implements PersistEntry {

    @EJB
    private BridgePersist bp;

    @Override
    public long persist() {
        return bp.persist();
    }

    @Override
    public Person queryObject(long id) {
        return bp.queryLazy(id);
    }

    @Override
    public String queryToString(long id) {
        Person obj = bp.queryLazy(id);
        StringBuilder sb = new StringBuilder(obj.getName());
        sb.append(" [");

        obj.getFruits().stream().forEach(f -> sb.append(f.getName()).append(" "));
        sb.append("]");

        return sb.toString();
    }

}
