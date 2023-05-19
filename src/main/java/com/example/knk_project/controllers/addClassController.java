package com.example.knk_project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class addClassController implements Initializable {

    @FXML
    private Button addClassButton;

    @FXML
    private Spinner<Integer> klasaSpinner;

    @FXML
    private Label messageLabel;

    @FXML
    private Spinner<Integer> paraleljaSpinner;

    @FXML
    private TextField vitiShkollorTextField;

    @FXML
    void addClassClick(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> klasaSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,12,6);
        this.klasaSpinner.setValueFactory(klasaSpinnerValueFactory);
        SpinnerValueFactory<Integer> paraleljaSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,20,1);
        this.paraleljaSpinner.setValueFactory(paraleljaSpinnerValueFactory);
    }
}
