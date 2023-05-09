package com.studentsattendance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class program extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(program.class.getResource
                ("views/login-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("program");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();

    }

    public static void main(String[] args) {
        launch();
    }
}