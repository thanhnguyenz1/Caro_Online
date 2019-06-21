package com.tgbao2004.caro.utils;

import com.jfoenix.controls.JFXButton;
import com.tgbao2004.caro.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jdk.jshell.execution.Util;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Dialog implements Initializable {

    public Scene previousScene;
    @FXML
    public Label content;
    public ImageView imageView;
    public JFXButton OKButton;

    public Dialog() {

    }

    /**
     * Return the new Dialog object
     * @return
     */
    public static Dialog newDialog() throws IOException {
        FXMLLoader loader = new FXMLLoader(Dialog.class.getResource("Dialog.fxml"));
        Parent pr = loader.load();
        Scene previousScene = Main.state.getScene();
        Utils.changeScene(new Scene(pr));
        Dialog dialog = loader.getController();
        dialog.previousScene = previousScene;
        return dialog;
    }

    /**
     * Default setting of Dialog
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }



    // Get Parent

    /**
     * Get Root Parent
     * @return
     * @throws IOException
     */
    public static Scene getRootParent() throws IOException {
        return new Scene(FXMLLoader.load(Dialog.class.getResource("Dialog.fxml")));
    }

    /**
     * Update the Dialog
     * @param content
     * @param imageView
     */
    public void updateDialog(Label content, ImageView imageView) {
        this.content.setText(content.getText());
        this.imageView.setImage(imageView.getImage());
    }

    /**'
     * Will call when player click OK button
     * Back to the previous scene
     * @param event
     */
    public void onClickedOKButton(ActionEvent event)
    {
        Utils.changeScene(previousScene);
    }
}
