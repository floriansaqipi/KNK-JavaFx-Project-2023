package com.example.knk_project.controllers;



import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainController {

    @FXML
    private AnchorPane mainPane = new AnchorPane();

    public void setMainPane(BorderPane mainPane) {
        this.mainPane.getChildren().clear();
        this.mainPane.getChildren().add(mainPane);
    }
}

