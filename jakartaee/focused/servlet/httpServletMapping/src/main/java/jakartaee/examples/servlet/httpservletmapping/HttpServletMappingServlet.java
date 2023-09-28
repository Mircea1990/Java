package jakartaee.examples.servlet.httpservletmapping;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * The servlet for the Servlet API HTTP servlet mapping example.
 */
@WebServlet(urlPatterns = "/*") public class HttpServletMappingServlet extends HttpServlet {

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
        HttpServletMapping httpServletMapping = request.getHttpServletMapping();
        writer.println("Servlet name: " + httpServletMapping.getServletName());
        writer.println("Pattern: " + httpServletMapping.getPattern());
        writer.println("Match value: " + httpServletMapping.getMatchValue());
        writer.println("Mapping match: " + httpServletMapping.getMappingMatch().toString());
    }
}
