package com.core;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/*
This class represents a basic servlet that can handle HTTP requests and generate responses.
 */
public class First implements Servlet {
    ServletConfig config = null;

    /*
    This method is called by the servlet container when the servlet is being initialized. It
    takes a ServletConfig object as a parameter, which provides configuration information for the
     servlet. In this example, the method sets the provided config object to the config variable
     and prints a message indicating that the servlet has been initialized.
     */
    public void init(ServletConfig config) {
        this.config = config;
        System.out.println("servlet is initialized");
    }

    /*
    This method is responsible for processing the incoming HTTP request and generating the
    appropriate response. It takes the ServletRequest object representing the request and the
    ServletResponse object representing the response. In this example, it sets the content type
    of the response to "text/html", creates a PrintWriter to write the HTML response, and writes
    a simple HTML message to the response output.
     */
    public void service(ServletRequest req, ServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.print("<html><body>");
        out.print("<b>Hello message!</b><br>");
        out.print(getServletInfo()); // Display servlet info on a new line
        out.print("</body></html>");
    }

    /*
    This method is called by the servlet container when the servlet is being destroyed. It is
    typically used to release any resources held by the servlet. In this example, it simply
    prints a message indicating that the servlet has been destroyed.
     */
    public void destroy() {
        System.out.println("servlet is destroyed");
    }

    /*
    This method returns the ServletConfig object associated with the servlet. In this example, it
     returns the config object that was set during initialization.
     */
    public ServletConfig getServletConfig() {
        return config;
    }

    /*
    This method returns a string that provides information about the servlet. In this example, it
     returns the static string "copyright 2007-1010".
     */
    public String getServletInfo() {
        return "Simple servlet info!";
    }

}
