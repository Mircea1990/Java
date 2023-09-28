package jakartaee.examples.servlet.webfilter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;

/**
 * The Filter for the @WebFilter example.
 */
@WebFilter(urlPatterns = "/*") public class WebFilterFilter extends HttpFilter {

    /**
     * Process the filter.
     *
     * @param request  the request.
     * @param response the response.
     * @param chain    the filter chain.
     * @throws IOException      when an I/O error occurs.
     * @throws ServletException when a Servlet error occurs.
     */
    @Override public void doFilter(ServletRequest request,
                                   ServletResponse response,
                                   FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        PrintWriter writer = httpServletResponse.getWriter();
        writer.println("And we called an @WebFilter filter");
    }
}
