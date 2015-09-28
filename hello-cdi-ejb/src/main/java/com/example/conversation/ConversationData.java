package com.example.conversation;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;

@ConversationScoped
public class ConversationData implements Serializable {

    private static final long serialVersionUID = -568388030644832754L;

    @Inject
    private Conversation conversation;

    @Inject
    private SelectedName selectedName;

    @PostConstruct
    public void init() {
        System.out.println("Conversiont PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Conversation PreDestroy");
    }

    public String getSelectedName() {
        return selectedName.get();
    }

    public void setSelectedName(String name) {
        this.selectedName.set(name);
    }

    public void begin() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    public void end() {
        if (!conversation.isTransient()) {
            System.out.println("destroy: " + conversation.getId());
            conversation.end();
        }
    }

    public String getCid() {
        return conversation.getId();
    }
}
