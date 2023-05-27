package com.example.knk_project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminHomePageController {


    private MainController mainController;

    @FXML
    void loadDashboard(ActionEvent event) {
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/admin-dashboard.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            AdminDashboardController adminDashboardController = fxmlLoader.getController();
//            adminDashboardController.setMain
            mainController.setMainPane(anchorPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
