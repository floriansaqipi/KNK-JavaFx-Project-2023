package com.example.knk_project.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homePageController implements Initializable {
    @FXML
    private AnchorPane anchorePaneHomePage;

    @FXML
    private MenuItem adminItem;

    @FXML
    private MenuItem studentItem;

    @FXML
    private MenuItem professorItem;


    // Action event handler for the adminItem
    @FXML
    private void adminSignUp(ActionEvent actionEvent) {
        loadFXML("sign-up-admin-view");
    }

    // Action event handler for the studentItem
    @FXML
    private void studentSignUp(ActionEvent actionEvent) {
        loadFXML("sign-up-nxenesi-view");
    }

    // Action event handler for the professorItem
    @FXML
    private void professorSignUp(ActionEvent actionEvent) {
        loadFXML("sign-up-profesori-view");
    }
    public void adminLogIn(ActionEvent actionEvent) {
        loadFXML("log-in-admin-view");
    }
    public void studentLogIn(ActionEvent actionEvent) {
        loadFXML("log-in-nxenesi-view");
    }
    public void professorLogIn(ActionEvent actionEvent){
        loadFXML("log-in-profesori-view");

    }

    private void loadFXML(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" + fxmlPath + ".fxml"));
            AnchorPane loadedPane = loader.load();
            anchorePaneHomePage.getChildren().setAll(loadedPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
