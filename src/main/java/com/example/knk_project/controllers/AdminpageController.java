package com.example.knk_project.controllers;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminpageController implements Initializable {

    @FXML
    private ImageView ExitImageView;

    @FXML
    private Label MenuCloseLabel;

    @FXML
    private Label MenuLabel;

    @FXML
    private AnchorPane sliderAnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ExitImageView.setOnMouseClicked(event ->{
            System.exit(0);
        });
        sliderAnchorPane.setTranslateX(-176);
        MenuLabel.setOnMouseClicked(event->{
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(sliderAnchorPane);
            slide.setToX(0);
            slide.play();
            sliderAnchorPane.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e) ->{
                MenuLabel.setVisible(false);
                MenuCloseLabel.setVisible(true);
            });
        });

        MenuCloseLabel.setOnMouseClicked(event->{
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(sliderAnchorPane);
            slide.setToX(-176);
            slide.play();

            sliderAnchorPane.setTranslateX(0);
            slide.setOnFinished((ActionEvent e) ->{
                MenuLabel.setVisible(true);
                MenuCloseLabel.setVisible(false);
            });
        });

    }

}
