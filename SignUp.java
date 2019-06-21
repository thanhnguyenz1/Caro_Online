package com.tgbao2004.caro.account;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.tgbao2004.caro.utils.Dialog;
import com.tgbao2004.caro.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUp implements Initializable {

    @FXML
    private JFXTextField inputUserName;
    public JFXPasswordField inputPassword;
    public JFXPasswordField inputPasswordConfirm;
    public JFXButton signUpButton;
    public JFXButton backButton;
    public Thread thread;

    public SignUp() {

    }

    /**
     * Initialize when scene are created
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showSignUpButton();
    }


    /**
     * Get scene of SignUp from file
     *
     * @return
     * @throws IOException
     */
    public Scene getRootParent() throws IOException {
        return new Scene(FXMLLoader.load(Login.class.getResource("SignUp.fxml")));
    }


    /**
     * Will call when player click back button
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onClickedBackButton(ActionEvent actionEvent) throws IOException {
        discard();
        Utils.changeScene(new Login().getRootParent());
    }


    /**
     * Will call when player click sign up button
     *
     * @param actionEvent
     */
    public void onClickedSignUpButton(ActionEvent actionEvent) throws IOException {
        Dialog dialog = Dialog.newDialog();
        //Do some thing with this Dialog

        //Update dialog
        dialog.updateDialog(new Label("Loading..."), new ImageView(new Image("com/tgbao2004/caro/loading.gif")));
    }


    /**
     * Use to show/hide sign up button if player fill/unfill input
     */
    public void showSignUpButton() {
        boolean[] isFilledUserName = {false};
        boolean[] isFilledPassword = {false};
        boolean[] isFilledPasswordConfirm = {false};
        inputUserName.textProperty().addListener((observable, oldValue, newValue) -> {
            isFilledUserName[0] = !newValue.trim().isEmpty();
        });
        inputPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            isFilledPassword[0] = !newValue.trim().isEmpty();
        });
        inputPasswordConfirm.textProperty().addListener((observable, oldValue, newValue) -> {
            isFilledPasswordConfirm[0] = !newValue.trim().isEmpty();
        });

        // Initialize thread to set disable of button
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    signUpButton.setDisable(!(isFilledUserName[0] && isFilledPassword[0] && isFilledPasswordConfirm[0]));
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
