package com.tgbao2004.caro.account;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUp implements Initializable {

    @FXML
    private JFXTextField userName;
    public JFXPasswordField cpassword; //confirm password
    public JFXPasswordField password;
    public JFXButton createAccount;
    public JFXButton backButton;

    // Initialize
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // buttonSubmit will be visiabled if player didn't fill account & password
    }

    // Get Parent
    public static Scene getRootParent() throws IOException {
        return new Scene(FXMLLoader.load(LoginGui.class.getResource("LoginGui.fxml")));
    }

    public void createAccountClicked(MouseEvent mouseEvent) {

    }

    public void backButtonClicked(MouseEvent mouseEvent) {

    }
}
