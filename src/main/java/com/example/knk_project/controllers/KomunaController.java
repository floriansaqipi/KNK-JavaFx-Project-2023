package com.example.knk_project.controllers;

import com.example.knk_project.models.Shteti;
import com.example.knk_project.services.exceptions.DifferentPasswordsException;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class KomunaController implements Initializable {

    private ValidatorInterface validator = new ValidatorService();

    @FXML
    private TextField komunaTextField;

    @FXML
    private Label messageLabel;

    @FXML
    private ComboBox<Shteti> shtetiComboBox = new ComboBox<>()  ;

    private Shteti[] options = {new Shteti(1,"asdfasdf"), new Shteti(2,"adasdada"), new Shteti(3,"adasdad")};

    @FXML
    void shtoKomunaClick(ActionEvent event) {
        this.validateInputs();

    }

    private void validateInputs(){
        this.validator.validateTextField(komunaTextField);
        this.validator.validateComboBox(shtetiComboBox);
        try{
            this.validator.throwIfInvalid();
        }catch (ValidationException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.shtetiComboBox.getItems().addAll(this.options);
        this.shtetiComboBox.setConverter(new StringConverter<Shteti>() {

            @Override
            public String toString(Shteti object) {
                return object.getEmri();
            }

            @Override
            public Shteti fromString(String string) {
                return shtetiComboBox.getItems().stream().filter(ap ->
                        ap.getEmri().equals(string)).findFirst().orElse(null);
            }
        });
    }
}