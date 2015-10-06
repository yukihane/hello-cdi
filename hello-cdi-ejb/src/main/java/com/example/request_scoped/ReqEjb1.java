package com.example.request_scoped;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class ReqEjb1 {

    @Inject
    private RequestScopedSpace spece;

    public void store(String text) {
        spece.setText(text);
    }

}
