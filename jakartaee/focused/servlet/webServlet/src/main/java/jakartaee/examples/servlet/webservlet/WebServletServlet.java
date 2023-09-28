package jakartaee.examples.servlet.webservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * The Servlet for the Servlet API @WebServlet example.
 */
@WebServlet(urlPatterns = "/*") public class WebServletServlet extends HttpServlet {

    /**
     * Process GET.
     *
     * @param request  the request.
     * @param response the response
     * @throws ServletException when a Servlet error occurs.
     * @throws IOException      when an I/O error occurs.
     */
    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("And we called an @WebServlet servlet");
    }
}
