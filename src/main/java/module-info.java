module com.example.knk_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.jfoenix;


    opens com.example.knk_project to javafx.fxml;
    exports com.example.knk_project;

    opens com.example.knk_project.controllers;
    exports com.example.knk_project.controllers;
    opens com.example.knk_project.services.validators;
    exports com.example.knk_project.services.validators;
    exports com.example.knk_project.services;
    opens com.example.knk_project.services;


}