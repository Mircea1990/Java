package com.example.spring43.attributeannotations;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// This class extends HandlerInterceptorAdapter, which is an abstract adapter class for the
// HandlerInterceptor interface for simplified implementation of pre-only/post-only interceptors.
public class ParamInterceptor extends HandlerInterceptorAdapter {

    // The preHandle method is overridden from HandlerInterceptorAdapter. This method will be
    // executed before the actual handler is executed.
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        // The getSession method is called on the HttpServletRequest object to get the current
        // HTTP session associated with this request.
        // The setAttribute method is then called on the HttpSession object to bind an object to
        // this session, using the name 'login' and the value 'john'.
        request.getSession().setAttribute("login", "john");

        // The setAttribute method is called on the HttpServletRequest object to store an
        // attribute in this request, using the name 'query' and the value 'invoices'.
        request.setAttribute("query", "invoices");

        // The preHandle method of the superclass (HandlerInterceptorAdapter) is then called with
        // the same arguments that were passed into this method.
        // This call is necessary for the interceptor to work correctly. It should return true to
        // allow further processing of the request, or false otherwise.
        return super.preHandle((javax.servlet.http.HttpServletRequest) request,
                               (javax.servlet.http.HttpServletResponse) response, handler);
    }
}


