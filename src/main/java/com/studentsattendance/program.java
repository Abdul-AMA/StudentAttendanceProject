package com.studentsattendance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class program extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(program.class.getResource("login-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(),1280,800);
        stage.setTitle("program");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setMinHeight(700);
        stage.setMinWidth(800);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}