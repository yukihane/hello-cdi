package com.example.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.conversation.ConversationData;

/**
 * Servlet implementation class ConversationServlet
 */
@WebServlet("/conversation/conversation1")
public class ConversationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private ConversationData data;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConversationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("doGet called");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException {

        String value = request.getParameter("animal");
        System.out.println("value: " + value);

        System.out.println("CID: " + data.getCid());
        data.begin();
        String cid = data.getCid();
        System.out.println("begin, cid: " + cid);
        request.setAttribute("cid", data.getCid());
        data.setSelectedName(value);
        request.getRequestDispatcher("page2.jsp").forward(request, response);
    }

}
