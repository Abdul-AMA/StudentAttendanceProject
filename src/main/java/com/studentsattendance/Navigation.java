package com.studentsattendance;

import com.studentsattendance.program;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Navigation {

    public static final String Login_FXML = "views/login-view.fxml";
    public static final String Teacher_FXML = "views/teacher-view.fxml";
    public static final String Admin_FXML = "views/admin-view2.fxml";
    public static final String FORGET_FXML = "views/forget-view.fxml";


    public void navigateTo(Parent rootPane, String path) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(path)));
            Scene scene = new Scene(root);
            Stage window = ((Stage) rootPane.getScene().getWindow());
            window.setScene(scene);
            window.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    

}
