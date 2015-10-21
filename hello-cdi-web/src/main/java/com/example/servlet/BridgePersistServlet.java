package com.example.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.bridge_persist.PersistEntry;
import com.example.entity.Person;

@WebServlet(urlPatterns = { "/bridge_persist/persist", "/bridge_persist/queryObject", "/bridge_persist/queryText" })
public class BridgePersistServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private PersistEntry pe;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final String path = request.getRequestURI();
        final HttpSession sess = request.getSession();

        if (path.contains("queryObject")) {
            long id = (long) sess.getAttribute("id");
            Person obj = pe.queryObject(id);
            StringBuilder sb = new StringBuilder().append(obj.getName()).append("[");
            obj.getFruits().stream().forEach(f -> sb.append(f.getName()).append(" "));
            sb.append("]");
            sess.setAttribute("person", sb.toString());
        } else if (path.contains("queryText")) {
            long id = (long) sess.getAttribute("id");
            String text = pe.queryToString(id);
            sess.setAttribute("person", text);
        } else {
            long id = pe.persist();
            sess.setAttribute("id", id);
            sess.setAttribute("person", "(persisted)");
        }

        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/bridge_persist/index.jsp");
        rd.forward(request, response);
    }

}
