package jakartaee.examples.servlet.pushbuilder;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.PushBuilder;

/**
 * A Servlet API PushBuilder servlet.
 */
@WebServlet(urlPatterns = "/index.html") public class PushBuilderServlet extends HttpServlet {

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
        PushBuilder pushBuilder = request.newPushBuilder();
        if (pushBuilder != null) {
            pushBuilder.path("image.png").addHeader("Content-Type", "image/png").push();
        }

        try (PrintWriter respWriter = response.getWriter();) {
            respWriter.write("<html>");
            respWriter.write(" <head>");
            respWriter.write(" </head>");
            respWriter.write(" <body>");
            respWriter.write("  The image below was pushed automatically during the GET <br/>");
            respWriter.write("  <img src=\"image.png\" width=\"200\" height=\"200\"/>");
            respWriter.write("  Note this will only work if your server is supports HTTP/2 <br/>");
            respWriter.write(" <body>");
            respWriter.write("</html>");
        }
    }
}
