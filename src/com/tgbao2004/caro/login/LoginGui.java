package com.tgbao2004.caro.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.MapChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginGui implements Initializable {

    @FXML
    public Label labelAccount;
    public JFXTextField inputAccount;
    public JFXButton buttonSubmit;

    // Initialize
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // labelAccount, buttonSubmit will be visiabled if player fill into input
        inputAccount.textProperty().addListener((observable, oldValue, newValue) -> {
            labelAccount.setVisible(!newValue.trim().isEmpty());
            buttonSubmit.setDisable(newValue.trim().isEmpty());
        });
    }

    // Get Parent
    public static Scene getRootParent() throws IOException {
        return new Scene(FXMLLoader.load(LoginGui.class.getResource("LoginGui.fxml")));
    }

    // Event Handler
    public void onSubmitLogin(ActionEvent actionEvent) {
        System.out.println(inputAccount.getText());
    }

}
