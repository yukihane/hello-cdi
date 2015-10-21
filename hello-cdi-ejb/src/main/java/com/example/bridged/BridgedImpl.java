package com.example.bridged;

import javax.ejb.Stateless;

@Stateless
public class BridgedImpl implements Bridged {

    @Override
    public String bredged() {
        return "bridged!!!";
    }

}
