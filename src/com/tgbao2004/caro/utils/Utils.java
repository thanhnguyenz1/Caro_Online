package com.tgbao2004.caro.utils;

import com.tgbao2004.caro.Main;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Utils {

    public static void changeScense(Scene scene) {
        Stage stage = Main.state;
        stage.setScene(scene);
    }

}
