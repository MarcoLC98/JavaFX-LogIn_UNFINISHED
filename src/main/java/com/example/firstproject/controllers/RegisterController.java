package com.example.firstproject.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {
    @FXML
    private Label userGenerationLbl;
    @FXML
    private Label invalidPassLbl;
    @FXML
    private Button cancelBtnReg;
    @FXML
    private PasswordField setPassField;
    @FXML
    private PasswordField setPassField2;
    @FXML
    private TextField nameTxtField;
    @FXML
    private TextField lastNameTxtField;
    @FXML
    private TextField usernameTxtField;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("com/example/firstproject/bg_1.png");
        Image imgLogin = new Image(brandingFile.toURI().toString());

        File file = new File("\"com/example/firstproject/bg_1.png\"");

    }

    public void registerBtn() {
        if (setPassField.getText().equals(setPassField2.getText())) {
            invalidPassLbl.setText("User registered!");
        } else {
            invalidPassLbl.setText("Passwords don't match");
        }
    }

    public void registerUser() {
        DatabaseConnection connection = new DatabaseConnection();
        Connection cnx = connection.getConnection();

        String firstname = nameTxtField.getText();
        String lastname = lastNameTxtField.getText();
        String username = usernameTxtField.getText();
        String password = setPassField.getText();

        String insertFields = "INSERT INTO user_account( second_name, name, user_name, password) VALUES (' ";
        String insertValues = firstname + " ' , ' " + lastname + " ' , ' " + username + " ' , ' " + password + "  ' )";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = cnx.createStatement();
            statement.executeUpdate(insertToRegister);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void registerBtnOnAction(javafx.event.ActionEvent event) {
        userGenerationLbl.setText("User has been registered successfully!");
        registerUser();
    }

    public void cancelBtnOnAction(javafx.event.ActionEvent event) {
        Stage stage = (Stage) cancelBtnReg.getScene().getWindow();
        stage.close();
        Platform.exit();
    }
}
