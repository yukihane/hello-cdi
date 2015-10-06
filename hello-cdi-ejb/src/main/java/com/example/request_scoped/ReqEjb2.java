package com.example.request_scoped;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class ReqEjb2 {

    @Inject
    private RequestScopedSpace space;

    public String load() {
        return space.getText();
    }
}
