package com.example.knk_project.controllers;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class BaseController implements Initializable{
    Locale locale = Locale.getDefault();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("com.example.knk_project.translations.content",locale);


    public void loadLang(){
        Locale locale = Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("com.example.knk_project.translations.content",locale);
        this.translate(resourceBundle);

    }

    abstract public void translate(ResourceBundle bundle);

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }
}
