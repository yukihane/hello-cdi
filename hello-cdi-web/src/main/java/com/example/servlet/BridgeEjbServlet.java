package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.bridge.Bridge;

@WebServlet("/bridge_ejb")
public class BridgeEjbServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private Bridge bridge;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<h1>" + bridge.getBridgeText() + "</h1>");
        }

    }

}
