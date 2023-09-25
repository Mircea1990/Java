package com.dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet1") public class Login extends HttpServlet {

    @Override public void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String userName = request.getParameter("userName");
            String userPass = request.getParameter("userPass");

            if (validateCredentials(userName, userPass)) {
                RequestDispatcher rd = request.getRequestDispatcher("servlet2");
                rd.forward(request, response);
            } else {
                out.print("Sorry, incorrect username or password!");

                // Clear browser cache
                response.setHeader("Cache-Control",
                                   "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                response.setDateHeader("Expires", 0); // Proxies.

                RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                rd.include(request, response);
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private boolean validateCredentials(String userName, String userPass) {
        return userName.equals("admin") && userPass.equals("servlet");
    }
}