package com.tgbao2004.caro;

import com.tgbao2004.caro.login.LoginGui;
import com.tgbao2004.caro.utils.Utils;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage state;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        state = primaryStage;
        state.setResizable(false);

        Utils.changeScense(LoginGui.getRootParent());

        state.show();
    }


}
