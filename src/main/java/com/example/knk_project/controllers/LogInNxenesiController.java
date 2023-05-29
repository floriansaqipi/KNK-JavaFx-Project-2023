package com.example.knk_project.controllers;

import com.example.knk_project.models.Nxenesi;
import com.example.knk_project.services.NxenesiService;
import com.example.knk_project.services.exceptions.IncorrectPasswordException;
import com.example.knk_project.services.exceptions.UserNotFoundException;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.NxenesiServiceInterface;
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

public class LogInNxenesiController extends BaseController implements Initializable {
    private MainController mainController;

    private ResourceBundle bundle;
    @FXML
    private Button logInButton;

    @FXML
    private Label logInStudentBanner;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Label messageLabel;

    private NxenesiServiceInterface nxenesiService = new NxenesiService();

    private ValidatorInterface validatorSerice = new ValidatorService();

    public void logInClick(){
        try{

        this.validateInputs();
        String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();
        this.nxenesiService.logIn(username,password);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/studentpage-view.fxml"));
            BorderPane nxenesiPagePane = fxmlLoader.load();
            StudentPageController studentPageController = fxmlLoader.getController();
            studentPageController.setMainController(mainController);
            Nxenesi nxenesi = this.nxenesiService.getNxenesiByUsername(username);
            studentPageController.setNxenesi(nxenesi);
            studentPageController.initData();
            mainController.setMainPane(nxenesiPagePane);
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

    private void validateInputs() throws ValidationException {
        this.validatorSerice.validateTextField(usernameTextField);
        this.validatorSerice.validateGeneralPasswordField(passwordPasswordField);
        this.validatorSerice.throwIfInvalid();

    }

    @FXML
    void loadAlbanianText(ActionEvent event) {
        Locale.setDefault(new Locale("sq"));
        loadLang();
        this.bundle = super.getResourceBundle();
        this.validatorSerice.setBundle(bundle);
    }

    @FXML
    void loadEnglishText(ActionEvent event) {
        Locale.setDefault(new Locale("en"));
        loadLang();
        this.bundle = super.getResourceBundle();
        this.validatorSerice.setBundle(bundle);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void translate(ResourceBundle bundle) {
        this.logInStudentBanner.setText(bundle.getString("login.student.banner"));
        this.usernameTextField.setPromptText(bundle.getString("login.username.placeholder"));
        this.passwordPasswordField.setPromptText(bundle.getString("login.password.placeholder"));
        this.logInButton.setText(bundle.getString("login.button.text"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.bundle = super.getResourceBundle();
        this.validatorSerice.setBundle(bundle);
        loadLang();
    }
}
