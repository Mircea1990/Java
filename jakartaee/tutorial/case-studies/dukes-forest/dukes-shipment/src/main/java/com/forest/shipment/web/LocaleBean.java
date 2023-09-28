package com.forest.shipment.web;

import java.io.Serializable;
import java.util.Locale;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named(value = "localeBean") @SessionScoped public class LocaleBean implements Serializable {

    private static final long serialVersionUID = -5322261872682904868L;
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    /**
     * Creates a new instance of LocaleBean
     */
    public LocaleBean() {
    }

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

}
