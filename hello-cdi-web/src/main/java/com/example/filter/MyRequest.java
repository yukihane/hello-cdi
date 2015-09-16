package com.example.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {

    /**
     * CDIがConversation scope を管理するIDを設定するリクエストパラメータkey.
     */
    private static final String CID_KEY = "cid";
    private final String cid;

    public MyRequest(HttpServletRequest request, String cid) {
        super(request);
        this.cid = cid;
    }

    @Override
    public HttpServletRequest getRequest() {
        return (HttpServletRequest) super.getRequest();
    }

    @Override
    public String getParameter(String name) {
        if (CID_KEY.equals(name)) {
            return cid;
        }
        return super.getParameter(name);
    }

}
