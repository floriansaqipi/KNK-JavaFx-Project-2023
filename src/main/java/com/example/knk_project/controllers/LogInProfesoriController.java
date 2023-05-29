package com.example.knk_project.controllers;

import com.example.knk_project.models.Profesori;
import com.example.knk_project.services.ProfesoriService;
import com.example.knk_project.services.exceptions.IncorrectPasswordException;
import com.example.knk_project.services.exceptions.UserNotFoundException;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.ProfesoriServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;


public class LogInProfesoriController extends BaseController implements Initializable {
    private MainController mainController;

    private ResourceBundle bundle;

    @FXML
    private Button logInButton;

    @FXML
    private Label logInProfessoriBanner;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private Label messageLabel;

    private ProfesoriServiceInterface profesoriService = new ProfesoriService();

    private ValidatorInterface validatorService = new ValidatorService();

    public void logInClick() {

        try {
            this.validateInputs();
            String username = usernameTextField.getText();
            String password = passwordPasswordField.getText();

            this.profesoriService.logIn(username, password);
            this.messageLabel.setText("Log in was successfull");


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/profesor-page-view.fxml"));
            BorderPane profesorPagePane = fxmlLoader.load();
            ProfesorPageController profesorPageController = fxmlLoader.getController();
            profesorPageController.setMainController(mainController);
            Profesori profesori = this.profesoriService.getProfesorByUsername(username);
            profesorPageController.setProfesori(profesori);
            profesorPageController.initData();
            mainController.setMainPane(profesorPagePane);
        } catch (ValidationException exception){
            exception.printStackTrace();
            this.messageLabel.setText(bundle.getString("login.invalid.inputs"));
        }catch (UserNotFoundException exception){
            exception.printStackTrace();
            this.messageLabel.setText(bundle.getString("user.not.found"));
        } catch (IncorrectPasswordException exception){
            exception.printStackTrace();
            this.messageLabel.setText(bundle.getString("incorrect.password"));
        } catch (SQLException exception){
            exception.printStackTrace();
            this.messageLabel.setText(bundle.getString("sql.ex"));
        }
        catch (IOException exception) {
            exception.printStackTrace();
            this.messageLabel.setText(bundle.getString("io.ex"));
        }

    }

    @FXML
    void loadAlbanianText(ActionEvent event) {
        Locale.setDefault(new Locale("sq"));
        loadLang();
        this.bundle = super.getResourceBundle();
        this.validatorService.setBundle(bundle);
    }

    @FXML
    void loadEnglishText(ActionEvent event) {
        Locale.setDefault(new Locale("en"));
        loadLang();
        this.bundle = super.getResourceBundle();
        this.validatorService.setBundle(bundle);
    }



    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    private void validateInputs() throws ValidationException {
        this.validatorService.validateTextField(usernameTextField);
        this.validatorService.validateGeneralPasswordField(passwordPasswordField);
        this.validatorService.throwIfInvalid();
    }

    @Override
    public void translate(ResourceBundle bundle) {
        this.logInProfessoriBanner.setText(bundle.getString("login.professor.banner"));
        this.usernameTextField.setPromptText(bundle.getString("login.username.placeholder"));
        this.passwordPasswordField.setPromptText(bundle.getString("login.password.placeholder"));
        this.logInButton.setText(bundle.getString("login.button.text"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.bundle = super.getResourceBundle();
        this.validatorService.setBundle(bundle);
        loadLang();
    }
}
