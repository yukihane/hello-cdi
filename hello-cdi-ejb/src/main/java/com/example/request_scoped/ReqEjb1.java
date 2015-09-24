package com.example.request_scoped;

import javax.inject.Inject;

public class ReqEjb1 {

    @Inject
    private RequestScopedSpace spece;

    public void store(String text) {
        spece.setText(text);
    }

}
