package com.example.firstproject.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public Label createAccRef;
    @FXML
    private ImageView  imgLogin;
    @FXML
    private PasswordField enterPassField;
    @FXML
    private Button submitBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField enterUserField;

    public LoginController() {
    }

    public void cancelBtnAcc() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    public void logInBtnAcc(ActionEvent event) {
        if (!enterPassField.getText().isBlank() && enterPassField.getText().isBlank() == false) {
            submitBtn.setText("Check your credentials!");
        } else {
        }
    }

    public void validateLogin() {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionDB = connection.getConnection();
        String verifyLogin = "SELECT count(1) FROM user_account WHERE  user_name = ' " + enterPassField.getText() + " ' AND password = '" + enterPassField.getText() + '"';
        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    submitBtn.setText("Congratulations!");
                } else {
                    submitBtn.setText("Invalid LogIn, try again");
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            exception.getCause();
        }
    }

    public void createAccForm() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            //FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
            Scene scene = new Scene(root, 400, 470);
            Stage regStage = new Stage();
            regStage.initStyle(StageStyle.TRANSPARENT);
            regStage.setScene(scene);
            regStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File imgFile = new File("com/example/firstproject/bg_1.png");
        Image imgLogin = new Image(imgFile.toURI().toString());

        File file = new File("\"com/example/firstproject/bg_1.png\"");
        Image image;

    }
}
