package com.core;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/displayUser") public class DisplayUser extends HttpServlet {

    @Override public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();

            String userName = request.getParameter("user");

            pw.println("<html>");
            pw.println("<head><title>Welcome to DisplayUser</title></head>");
            pw.println("<body>");
            pw.println("<h1>Welcome " + userName + "</h1>");
            pw.println(
                    "<p>This is a simple demonstration servlet to display user information.</p>");
            pw.println("</body>");
            pw.println("</html>");

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
