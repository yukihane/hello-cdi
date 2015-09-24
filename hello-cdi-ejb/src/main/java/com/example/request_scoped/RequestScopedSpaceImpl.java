package com.example.request_scoped;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RequestScopedSpaceImpl implements RequestScopedSpace {

    private String text;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

}
