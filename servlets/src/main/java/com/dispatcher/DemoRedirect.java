package com.dispatcher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DemoRedirect extends HttpServlet {

    @Override public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();

            response.sendRedirect("http://www.google.com");

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
