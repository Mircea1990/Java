package com.example.scopes;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // This annotation indicates that the class is a web controller.
public class ScopesController {
    public static final Logger LOG = LoggerFactory.getLogger(ScopesController.class);
    // Logger instance for this class.
    @Resource(name = "requestScopedBean")  // Injects the bean with name "requestScopedBean".
            HelloMessageGenerator requestScopedBean;
    @Resource(name = "sessionScopedBean")  // Injects the bean with name "sessionScopedBean".
    HelloMessageGenerator sessionScopedBean;
    @Resource(name = "applicationScopedBean")
    // Injects the bean with name "applicationScopedBean".
    HelloMessageGenerator applicationScopedBean;

    @RequestMapping("/scopes/request")  // Mapping for "/scopes/request" URL.
    public String getRequestScopeMessage(final Model model) {
        model.addAttribute("previousMessage",
                           requestScopedBean.getMessage());  // Adds attribute to model.
        requestScopedBean.setMessage(
                "Request Scope Message!");  // Sets new message to request scoped bean.
        model.addAttribute("currentMessage",
                           requestScopedBean.getMessage());  // Adds attribute to model.
        return "scopesExample";  // Returns view name.
    }

    @RequestMapping("/scopes/session")  // Mapping for "/scopes/session" URL.
    public String getSessionScopeMessage(final Model model) {
        model.addAttribute("previousMessage",
                           sessionScopedBean.getMessage());  // Adds attribute to model.
        sessionScopedBean.setMessage(
                "Session Scope Message!");  // Sets new message to session scoped bean.
        model.addAttribute("currentMessage",
                           sessionScopedBean.getMessage());  // Adds attribute to model.
        return "scopesExample";  // Returns view name.
    }

    @RequestMapping("/scopes/application")  // Mapping for "/scopes/application" URL.
    public String getApplicationScopeMessage(final Model model) {
        model.addAttribute("previousMessage",
                           applicationScopedBean.getMessage());  // Adds attribute to model.
        applicationScopedBean.setMessage(
                "Application Scope Message!");  // Sets new message to application scoped bean.
        model.addAttribute("currentMessage",
                           applicationScopedBean.getMessage());  // Adds attribute to model.
        return "scopesExample";  // Returns view name.
    }
}

