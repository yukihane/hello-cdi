package com.example.bridge;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.example.bridged.Bridged;

@Stateless
public class BridgeImpl implements Bridge {
    
    @EJB
    private Bridged bridged;

    @Override
    public String getBridgeText() {
        return bridged.bredged();
    }

}
