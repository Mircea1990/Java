package com.core;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo") public class DemoServlet extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            PrintWriter pw = res.getWriter();

            pw.println("<html>");
            pw.println("<head><title>Welcome to DemoServlet</title></head>");
            pw.println("<body>");
            pw.println("<h1>Welcome to DemoServlet</h1>");
            pw.println("<p>This is a simple demonstration servlet.</p>");
            pw.println("</body>");
            pw.println("</html>");

            pw.close();
        } catch (IOException e) {
            // Handle the IOException here
            e.printStackTrace();
        }
    }
}