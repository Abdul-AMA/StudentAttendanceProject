package com.studentsattendance.controllers;

import com.studentsattendance.Navigation;
import com.studentsattendance.models.Administrator;
import com.studentsattendance.models.DataModel;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ForgetController implements Initializable {

    public AnchorPane rootPane;
    public TextField usernameInput;
    public Button buttonSubmit;
    public Hyperlink linkResend;
    public Label labelWrongPass;
    public Label labelTitle;
    public Button buttonBack;
    DataModel dataModel;
    Administrator administrator;
    String email;

    Navigation  navigation  = new Navigation();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataModel = new DataModel();
        administrator = dataModel.getAdministrator();
    }
    public void onSubmit(ActionEvent event) {
        if (usernameInput.getText().isEmpty()){
            labelWrongPass.setText("Enter username");
            return;
        }
        if (administrator.getUsername().equals(usernameInput.getText())) {
            labelWrongPass.setText("We sent your password to the email: \n" + administrator.getEmail());
            email = administrator.getEmail();
            linkResend.setVisible(true);
            return;
        }else
            for (int i = 0; i < administrator.getTeacherAssistantList().size(); i++) {
                if (    administrator.getTeacherAssistantList().get(i).getUsername().equals(usernameInput.getText())) {
                    labelWrongPass.setText("We sent your password to the email: \n" + administrator.getTeacherAssistantList().get(i).getEmail());
                    linkResend.setVisible(true);
                    return;
                }
            }
        labelWrongPass.setText("username doesn't exist");

    }

    public void onResend(ActionEvent event) {
        labelWrongPass.setText("بلاش");
    }

    public void onBack(ActionEvent event) {
        navigation.navigateTo(rootPane , Navigation.Login_FXML);
    }
}
