package com.example.conversation;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ConversationGetter {

    @Inject
    private ConversationData data;

    public String get() {
        return data.getSelectedName();
    }
}
