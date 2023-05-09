package com.studentsattendance.controllers;

import com.studentsattendance.Navigation;
import com.studentsattendance.models.Administrator;
import com.studentsattendance.models.DataModel;
import com.studentsattendance.models.TeacherAssistant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements  Initializable  {

    @FXML
    public AnchorPane rootPane;
    @FXML
    public Button buttonLogin;
    @FXML
    public TextField usernameInput;

    @FXML
    public PasswordField passwordInput;
    @FXML
    public Label labelWrongPass;

    Navigation navigation = new Navigation();

    DataModel dataModel;
    Administrator administrator;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataModel = new DataModel();
        administrator = dataModel.getAdministrator();
    }
    public void onLogin(ActionEvent actionEvent) {
        if (usernameInput.getText().isEmpty()){
            labelWrongPass.setText("Enter username");
            return;
        }else if (passwordInput.getText().isEmpty()){
            labelWrongPass.setText("Enter password");
            return;
        }
        if (administrator.getUsername().equals(usernameInput.getText()) &&
                administrator.getPassword().equals(passwordInput.getText())) {
                openAdminWindow();

            return;
        }else
            for (int i = 0; i < administrator.getTeacherAssistantList().size(); i++) {
                if (    administrator.getTeacherAssistantList().get(i).getUsername().equals(usernameInput.getText()) &&
                        administrator.getTeacherAssistantList().get(i).getPassword().equals(passwordInput.getText())) {
                    openTeacherWindow(administrator.getTeacherAssistantList().get(i));
                    return;
                }
            }
            labelWrongPass.setText("username or password is incorrect");


    }




    public void openAdminWindow( ){
        navigation.navigateTo(rootPane,navigation.Admin_FXML);

    }

    public void openTeacherWindow(TeacherAssistant teacherAssistant){
        navigation.navigateTo(rootPane,navigation.Teacher_FXML);
    }
    public void onForgetUsername() {

    }


}