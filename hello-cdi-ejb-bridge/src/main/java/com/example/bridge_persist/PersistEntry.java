package com.example.bridge_persist;

import javax.ejb.Local;

import com.example.entity.Person;

@Local
public interface PersistEntry {

    long persist();

    /**
     * lazy fetch が servlet側で行えるかを確認するためのメソッド
     */
    Person queryObject(long id);

    /**
     * EJBを呼び出したEJBの中でlazy fetchが行えるかを確認するためのメソッド
     */
    String queryToString(long id);
}
