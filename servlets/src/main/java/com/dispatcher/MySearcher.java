package com.dispatcher;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mySearcher") public class MySearcher extends HttpServlet {

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String toSearch = request.getParameter("toSearch");
            response.sendRedirect("https://www.google.com/search?q=" + toSearch);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}