package jakarta.tutorial.hello2_basicauth;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * This simple HTTP Servlet responds to the GET method of the HTTP protocol.
 */
@WebServlet(name = "ResponseServlet", urlPatterns = {"/response"}) public class ResponseServlet
        extends HttpServlet {

    @Override public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        // then write the data of the response
        String username = request.getParameter("username");
        if (username != null && username.length() > 0) {
            out.println("<h2>Hello, " + username + "!</h2>");
        }
    }

    @Override public String getServletInfo() {
        return "The Response servlet says hello.";

    }
}
