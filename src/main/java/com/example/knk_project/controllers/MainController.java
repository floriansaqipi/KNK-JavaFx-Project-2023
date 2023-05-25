package com.example.knk_project.controllers;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private AnchorPane mainPane = new AnchorPane();

    public void setMainPane(BorderPane mainPane) {
        this.mainPane.getChildren().clear();
        this.mainPane.getChildren().add(mainPane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/log-in-admin-view.fxml"));
//        try {
//            LogInAdminiController logInAdminiController = fxmlLoader.getController();
//            logInAdminiController.setMainController(this);
//            this.setMainPane(anchorPane);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}

