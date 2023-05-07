package com.studentsattendance.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import java.util.Objects;

public class Navigation {
    public static final String Login_FXML = "src/main/resources/com/studentsattendance/login-view.fxml";
    public static final String Teacher_FXML = "src/main/resources/com/studentsattendance/teacher-view.fxml";

    public static final String Admin_FXML = "admin-view.fxml";

    public void navigateTo(Parent rootPane, String path) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            rootPane.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
