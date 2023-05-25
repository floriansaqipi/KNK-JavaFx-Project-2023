package com.example.knk_project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class EditProfessorController {

    @FXML
    private PasswordField confirmPasswordPasswordField;

    @FXML
    private TextField emriTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField mbiemriTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private TextField titulliTextField;

    @FXML
    void saveDatasClick(ActionEvent event) {
        // Get the updated values from the fields
        String updatedId = idTextField.getText();
        String updatedEmri = emriTextField.getText();
        String updatedMbiemri = mbiemriTextField.getText();
        String updatedTitulli = titulliTextField.getText();
        String updatedPassword = passwordPasswordField.getText();
        String updatedConfirmPassword = confirmPasswordPasswordField.getText();

        if (!updatedPassword.equals(updatedConfirmPassword)) {
            // Show an error message or handle the validation failure
            System.out.println("Passwords do not match!");
            return;
        }


    }

}
