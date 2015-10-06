package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import com.example.logging.Log;
import com.example.samples.MyCdi;
import com.example.samples.intercept.MyBeanLocal;
import com.example.samples.jpa.EntityExecutor;
import com.example.samples.jpa.EntityGet;
import com.example.samples.jpa.EntityPrinter;
import com.example.samples.jpa.EntitySet;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/helloservlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    @Log
    private Logger logger;

    @Inject
    @Named("myCdiImpl1")
    private MyCdi myCdi;

    @Inject
    private EntityExecutor entityExecutor;

    @Inject
    private EntityGet entityGet;

    @Inject
    private EntitySet entitySet;

    @Inject
    private EntityPrinter entityPrinter;

    @Inject
    private MyBeanLocal myBean;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.error("serve log");

        myBean.hello();

        String hello = myCdi.hello();

        entityExecutor.execute();

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<h1>" + hello + "</h1>");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException {
        // TODO Auto-generated method stub
    }

}
