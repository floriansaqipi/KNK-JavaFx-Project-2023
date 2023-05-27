package com.example.knk_project.controllers;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.Komuna;
import com.example.knk_project.models.Profesori;
import com.example.knk_project.models.dto.CreateNxenesiDto;
import com.example.knk_project.models.dto.CreatePrindiDto;
import com.example.knk_project.services.*;
import com.example.knk_project.services.exceptions.DifferentPasswordsException;
import com.example.knk_project.services.exceptions.UserAlreadyExistsException;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.KlasaServiceInterface;
import com.example.knk_project.services.interfaces.KomunaServiceInterface;
import com.example.knk_project.services.interfaces.NxenesiServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.sql.Date;

public class SignUpNxenesiController implements Initializable {
    @FXML
    private TextField emriTextField;
    @FXML
    private TextField mbiemriTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private DatePicker dateLindjaDatePicker;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private ComboBox<Komuna> vendLindjaComboBox;
    @FXML
    private ComboBox<Komuna> komunaComboBox;
    @FXML
    private ComboBox<Klasa> klasaComboBox;
    @FXML
    private TextField adresaTextField;
    @FXML
    private TextField emriPrinditTextField;
    @FXML
    private TextField mbiemriPrinditTextField;
    @FXML
    private TextField profesioniPrinditTextField;
    @FXML
    private TextField numriTelefonitPrinditTextField;
    @FXML
    private TextField emailPrinditTextField;

    @FXML
    private Label messageLabel;


    private ValidatorInterface validator = new ValidatorService();
    private NxenesiServiceInterface signUpNxenesiService = new NxenesiService();
    private KomunaServiceInterface komunaService = new KomunaService();
    private KlasaServiceInterface klasaService = new KlasaService();

    public void signUpClick() {
        this.validateInputs();

        CreateNxenesiDto createNxenesiDto = this.initilializeCreateNxenesiDto();
        CreatePrindiDto createPrindiDto = this.initializeCreatePrindiDto();

        try {

            this.signUpNxenesiService.signUp(createNxenesiDto, createPrindiDto);
            this.messageLabel.setText("Successfully added user");
        } catch (UserAlreadyExistsException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Username is taken");
            } catch (SQLException exception) {
                exception.printStackTrace();
                this.messageLabel.setText("Something went wrong with the database");
            }


    }

    private void validateInputs() {
        this.validator.validateEmriTextField(emriTextField);
        this.validator.validateMbiemriTextField(mbiemriTextField);
        this.validator.validateUsernameTextField(usernameTextField);
        this.validator.validateDatePicker(dateLindjaDatePicker);
        this.validator.validatePasswordField(passwordPasswordField);
        this.validator.validatePasswordField(confirmPasswordField);
        this.validator.validateComboBox(vendLindjaComboBox);
        this.validator.validateComboBox(komunaComboBox);
        this.validator.validateComboBox(klasaComboBox);
        this.validator.validateTextField(adresaTextField);
        this.validator.validateEmriTextField(emriPrinditTextField);
        this.validator.validateMbiemriTextField(mbiemriPrinditTextField);
        this.validator.validatePhoneTextField(numriTelefonitPrinditTextField);
        this.validator.validateEmailTextField(emailPrinditTextField);
        try {
            this.validator.validateMatchingPasswords(passwordPasswordField, confirmPasswordField);
            this.validator.throwIfInvalid();
        } catch (ValidationException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        } catch (DifferentPasswordsException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Passwords must match");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.initializeVendlindjaComboBox();
            this.initializeKomunaComboBox();
            this.initializeKlasaComboBox();
        } catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }

    }

    private void initializeVendlindjaComboBox() throws SQLException {
        this.vendLindjaComboBox.getItems().addAll(this.komunaService.getAllKomunat());
        this.vendLindjaComboBox.setConverter(new StringConverter<Komuna>() {
            @Override
            public String toString(Komuna object) {
                return object.getEmri() + " (" + object.getId() + ")";
            }

            @Override
            public Komuna fromString(String string) {
                return vendLindjaComboBox.getItems().stream().filter(ap -> (ap.getEmri() + " " + " (" + ap.getId() + ")").equals(string)).findFirst().orElse(null);
            }
        });
    }

    private void initializeKomunaComboBox() throws SQLException {

        this.komunaComboBox.getItems().addAll(this.komunaService.getAllKomunat());
        this.komunaComboBox.setConverter(new StringConverter<Komuna>() {
            @Override
            public String toString(Komuna object) {
                return object.getEmri() + " (" + object.getId() + ")";
            }

            @Override
            public Komuna fromString(String string) {
                return komunaComboBox.getItems().stream().filter(ap -> (ap.getEmri() + " " + " (" + ap.getId() + ")").equals(string)).findFirst().orElse(null);
            }
        });
    }

    private void initializeKlasaComboBox() throws SQLException {
        this.klasaComboBox.getItems().addAll(this.klasaService.getAllKlasat());
        this.klasaComboBox.setConverter(new StringConverter<Klasa>() {
            @Override
            public String toString(Klasa object) {
                return IntegerRoman.intToRoman(object.getKlasa()) + "/" + object.getParalelja() + " " + object.getViti();
            }

            @Override
            public Klasa fromString(String string) {
                return klasaComboBox.getItems().stream().filter(ap -> (IntegerRoman.intToRoman(ap.getKlasa()) + "/" + ap.getParalelja() + " " + ap.getViti()).equals(string)).findFirst().orElse(null);
            }
        });
    }


    private CreateNxenesiDto initilializeCreateNxenesiDto() {
        String username = this.usernameTextField.getText();
        String emri = this.emriTextField.getText();
        String mbiemri = this.mbiemriTextField.getText();
        LocalDate localDate = this.dateLindjaDatePicker.getValue();
        Date dateLindja = Date.valueOf(localDate);
        String password = this.passwordPasswordField.getText();
        String salt = PasswordHasher.generateSalt();
        String saltedPassword = PasswordHasher.generateSaltedHash(password, salt);
        int vendLindjaId = this.vendLindjaComboBox.getValue().getId();
        int komunaId = this.komunaComboBox.getValue().getId();
        int klasaId = this.klasaComboBox.getValue().getId();

        return new CreateNxenesiDto(
                username,
                salt,
                saltedPassword,
                emri,
                mbiemri,
                dateLindja,
                vendLindjaId,
                komunaId,
                klasaId
        );
    }

    private CreatePrindiDto initializeCreatePrindiDto() {
        String emriPrindit = this.emriPrinditTextField.getText();
        String mbiemriPrindit = this.mbiemriPrinditTextField.getText();
        String adresa = this.adresaTextField.getText();
        String profesioni = this.profesioniPrinditTextField.getText();
        String numriTelefonitPrindit = this.numriTelefonitPrinditTextField.getText();
        String emailPrindit = this.emailPrinditTextField.getText();

        return new CreatePrindiDto(
                emriPrindit,
                mbiemriPrindit,
                profesioni,
                adresa,
                numriTelefonitPrindit,
                emailPrindit
        );
    }
}
