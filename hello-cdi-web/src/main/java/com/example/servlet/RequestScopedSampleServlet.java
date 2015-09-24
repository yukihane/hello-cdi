package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.request_scoped.ReqEjb1;
import com.example.request_scoped.ReqEjb2;

/**
 * Servlet implementation class RequestScopedSampleServlet
 */
@WebServlet("/RequestScopedSampleServlet")
public class RequestScopedSampleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private ReqEjb1 ejb1;

    @Inject
    private ReqEjb2 ejb2;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestScopedSampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ejb1.store("hello request scoped");
        String res = ejb2.load();

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<h1>" + res + "</h1>");
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
