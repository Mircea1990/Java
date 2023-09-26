package com.servletConfig;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DemoServletConfig extends HttpServlet {

    @Override public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            ServletConfig config = getServletConfig();
            String driver = config.getInitParameter("driver");
            out.print("Driver is: " + driver);

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}