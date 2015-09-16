package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class PreFilter implements Filter {

    private int initCalled = 0;
    private int doFilterCalled = 0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        initCalled++;
        System.out.println(filterConfig.getFilterName() + " init called: " + initCalled);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
        ServletException {
        doFilterCalled++;
        System.out.println("doFilter called: " + doFilterCalled);

        final ServletRequest req;
        if (request instanceof HttpServletRequest) {
            System.out.println("pre filter process");
            HttpServletRequest obj = (HttpServletRequest) request;
            String mycid = obj.getParameter("mycid");
            System.out.println("mycid: " + mycid);
            req = new MyRequest(obj, mycid);
        } else {
            req = request;
        }

        chain.doFilter(req, response);
    }

    @Override
    public void destroy() {
    }

}
