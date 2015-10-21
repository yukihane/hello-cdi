package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.generics.MyGenerics;

/**
 * <ul>
 * <li>抽象クラスはCDIのインジェクション処理に関与しないように見える.</li>
 * <li>型パラメータを含む場合は, 正確に型指定しないとエラーになるように見える.</li>
 * </ul>
 */
@WebServlet("/generics_inject")
public class GenericsInjectServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private MyGenerics<String> myGenerics;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<h1>" + myGenerics.hello() + "</h1>");
        }

    }

}
