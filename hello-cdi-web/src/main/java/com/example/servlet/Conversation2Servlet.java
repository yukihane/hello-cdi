package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.conversation.ConversationData;

/**
 * Servlet implementation class Conversation2Servlet
 */
@WebServlet("/conversation/conversation2")
public class Conversation2Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private ConversationData data;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Conversation2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException {
        data.end();
        String cid = data.getCid();
        System.out.println("CID: " + cid);
        System.out.println("conv data: " + data.getSelectedName());

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<h1>CID: " + cid + ", data: " + data.getSelectedName() + "</h1>");
        }
    }

}
