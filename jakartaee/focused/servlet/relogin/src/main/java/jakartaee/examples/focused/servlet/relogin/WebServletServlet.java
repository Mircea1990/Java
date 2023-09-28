package jakartaee.examples.focused.servlet.relogin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.annotation.security.DeclareRoles;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * The Servlet for the Servlet API Relogin example.
 */
@WebServlet(urlPatterns = "/*") @DeclareRoles("student") public class WebServletServlet
        extends HttpServlet {

    private static final long serialVersionUID = 1L;

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

        request.login("john", "changeit");

        writer.println("\n");

        writer.println("1:" + request.getUserPrincipal().getName());
        writer.println("1:" + request.isUserInRole("student"));

        request.logout();

        writer.println("2:" + (request.getUserPrincipal() == null ? "null" : "non-null"));

        request.login("john", "changeit");

        writer.println("3:" + request.getUserPrincipal().getName());
        writer.println("3:" + request.isUserInRole("student"));


    }
}
