package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.weld.context.ConversationContext;
import org.jboss.weld.context.http.Http;

import com.example.conversation.ConversationGetter;

/**
 * Servlet implementation class Conversation2Servlet
 */
@WebServlet("/conversation/conversation2")
public class Conversation2Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    @Http
    private ConversationContext conversationContext;

    @Inject
    private Conversation conversation;

    @Inject
    private ConversationGetter end;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Conversation2Servlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException {
        conversationContext.invalidate();
        conversationContext.deactivate();

        String cid = request.getParameter("mycid");
        conversationContext.activate(cid);

        System.out.println("CID: " + cid);
        String name = end.get();
        System.out.println("conv data: " + name);

        conversation.end();

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<h1>CID: " + cid + ", data: " + name + "</h1>");
        }
    }

}
