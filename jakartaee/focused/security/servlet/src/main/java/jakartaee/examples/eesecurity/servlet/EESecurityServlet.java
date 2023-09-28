package jakartaee.examples.eesecurity.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * A servlet example with EESecurity.
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = "user")) @WebServlet("/protected/*")
public class EESecurityServlet extends HttpServlet {

    /**
     * Handle the GET request.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().print("And voila we were allowed to see this!");
    }
}
