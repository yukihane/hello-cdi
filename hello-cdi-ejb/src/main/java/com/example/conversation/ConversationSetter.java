package com.example.conversation;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ConversationSetter {

    @Inject
    private ConversationData data;

    public void setName(String name) {

        String cid = data.getCid();
        System.out.println("CID: " + cid);
        data.setSelectedName(name);
    }
}
