package com.example.knk_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginApplication extends Application {
    public static Stage stg;
    @Override
    public void start(Stage primarystage) throws IOException {
        stg=primarystage;
        primarystage.setResizable(false);
        Parent root =FXMLLoader.load(getClass().getResource("login-admin-view.fxml"));
        primarystage.setTitle("Log in Admin");
        primarystage.setScene(new Scene(root,600,400));
        primarystage.show();
    }
    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
    public static void main(String[] args) {
        launch(args);
    }

}
