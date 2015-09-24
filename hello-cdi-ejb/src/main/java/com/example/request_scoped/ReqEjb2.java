package com.example.request_scoped;

import javax.inject.Inject;

public class ReqEjb2 {

    @Inject
    private RequestScopedSpace space;

    public String load() {
        return space.getText();
    }
}
