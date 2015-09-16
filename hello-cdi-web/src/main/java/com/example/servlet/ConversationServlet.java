package com.example.servlet;

import java.io.IOException;

import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.weld.context.ConversationContext;
import org.jboss.weld.context.http.Http;

import com.example.conversation.ConversationSetter;

/**
 * Servlet implementation class ConversationServlet
 */
@WebServlet("/conversation/conversation1")
public class ConversationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    @Http
    private ConversationContext conversationContext;

    @Inject
    private Conversation conversation;

    @Inject
    private ConversationSetter setter;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConversationServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet called");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException {

        String cid = conversation.getId();
        System.out.println("begin, cid: " + cid);

        conversation.begin();
        cid = conversation.getId();
        System.out.println("begin, cid: " + cid);

        String value = request.getParameter("animal");
        System.out.println("value: " + value);

        setter.setName(value);

        request.setAttribute("mycid", cid);
        request.getRequestDispatcher("page2.jsp").forward(request, response);
    }

}
