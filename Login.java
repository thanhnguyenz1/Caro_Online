package com.tgbao2004.caro.account;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.tgbao2004.caro.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    public JFXTextField inputUserName;
    public JFXPasswordField inputPassword;
    public JFXButton loginButton;
    public JFXButton signUpButton;
    public Thread thread;

    /**
     * Initialize when scene are created
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showLoginButton();
    }


    /**
     * Get scene of Login from file
     *
     * @return
     * @throws IOException
     */
    public Scene getRootParent() throws IOException {
        return new Scene(FXMLLoader.load(Login.class.getResource("Login.fxml")));
    }


    /**
     * Will call when player click login button
     *
     * @param actionEvent
     */
    public void onClickedLoginButton(ActionEvent actionEvent) {

    }


    /**
     * Will call when player click signup button
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onClickedSignUpButton(ActionEvent actionEvent) throws IOException {
        discard();
        Utils.changeScene(new SignUp().getRootParent());
    }


    /**
     * Use to show/hide button if player fill/unfill input
     */
    public void showLoginButton() {
        boolean[] isFilledUserName = {false};
        boolean[] isFilledPassword = {false};
        inputUserName.textProperty().addListener((observable, oldValue, newValue) -> {
            isFilledUserName[0] = !newValue.trim().isEmpty();
        });
        inputPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            isFilledPassword[0] = !newValue.trim().isEmpty();
        });

        // Initialize thread to set disable of button
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    loginButton.setDisable(!(isFilledUserName[0] && isFilledPassword[0]));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }


    /**
     * Will call when player change sence
     */
    public void discard() {
        thread.stop();
    }

}
