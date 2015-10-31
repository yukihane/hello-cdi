package com.example.bridge;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;

import com.example.bridged.Bridged;

@Stateless
@RequestScoped
public class BridgeImpl implements Bridge {
    
    @EJB
    private Bridged bridged;

    @Override
    public String getBridgeText() {
        return "aaa";
        // return bridged.bredged();
    }

}
