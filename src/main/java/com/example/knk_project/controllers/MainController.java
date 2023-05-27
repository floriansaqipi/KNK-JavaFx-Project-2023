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

    public void setMainPane(AnchorPane mainPane) {
        this.mainPane.getChildren().clear();
        this.mainPane.getChildren().add(mainPane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       try{
           this.intializeSetHomePage();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }

    private void intializeSetHomePage() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/homepage-view.fxml"));

            BorderPane borderPane = fxmlLoader.load();
            HomePageController homePageController = fxmlLoader.getController();
            homePageController.setMainController(this);
            this.setMainPane(borderPane);
//            LogInAdminiController logInAdminiController = fxmlLoader.getController();
//            logInAdminiController.setMainController(this);
//            this.setMainPane(anchorPane);


    }

    public void reset(){
        try{

        this.intializeSetHomePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

