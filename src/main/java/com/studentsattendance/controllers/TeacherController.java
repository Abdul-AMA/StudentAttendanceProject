package com.studentsattendance.controllers;

import com.studentsattendance.Navigation;
import com.studentsattendance.program;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class TeacherController {
    @FXML
    public AnchorPane rootPane;
    public Button teacherButton;
    Navigation navigation = new Navigation();


    public void onTeatcher() throws IOException {
        navigation.navigateTo(rootPane,Navigation.Login_FXML);
    }
}
