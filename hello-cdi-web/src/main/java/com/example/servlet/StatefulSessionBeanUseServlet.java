package com.example.servlet;

import com.example.logging.Log;
import com.example.sfsb_use.SFSBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;

/**
 * servletの中でStateful Session Beanを利用してみます(ライフサイクルの検証).
 *
 * @see http://leakfromjavaheap.blogspot.jp/2013/02/injecting-stateful-session-bean-into.html
 */
@WebServlet("/sfsb_use")
public class StatefulSessionBeanUseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    @Log
    private Logger log;

    // @EJB でインジェクションした場合と挙動が変わる
    @Inject
    private SFSBean bean;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {

        bean.addGreeting(req.getParameter("greeting"));
        final String text = "This user has already sent greetings: " + bean.getAllGreetings();
        log.info(text);

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<h1>" + text + "</h1>");
        }
    }
}
