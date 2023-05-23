package com.studentsattendance.controllers;

import com.studentsattendance.Navigation;
import com.studentsattendance.models.Administrator;
import com.studentsattendance.models.DataModel;
import com.studentsattendance.models.IndexHolder;
import com.studentsattendance.models.IndexHolder;
import com.studentsattendance.models.TeacherAssistant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
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
    public CheckBox checkShowPass;
    public TextField passShow;

    Navigation navigation = new Navigation();

    DataModel dataModel;
    Administrator administrator;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void onLogin(ActionEvent actionEvent) {
        dataModel = new DataModel();
        administrator = dataModel.getAdministrator();

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
                    IndexHolder.getInstance().setCurrentIndex(i);
                    openTeacherWindow();
                    return;
                }
            }
            labelWrongPass.setText("username or password is incorrect");


    }




    public void openAdminWindow( ){
        navigation.navigateTo(rootPane,navigation.Admin_FXML);

    }

    public void openTeacherWindow( ){
        navigation.navigateTo(rootPane,navigation.Teacher_FXML);
    }


    public void onForget(){
        navigation.navigateTo(rootPane,navigation.FORGET_FXML);
    }


    public void onShowPass(ActionEvent event) {
        if (checkShowPass.isSelected()){
            passShow.setText(passwordInput.getText());
            passShow.setVisible(true);
            passwordInput.setVisible(false);
        }else {
            passwordInput.setText(passShow.getText());
            passShow.setVisible(false);
            passwordInput.setVisible(true);
        }

    }

    public void onLostData(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Lost data");
        alert.setHeaderText("Are you sure you want to load the recovery file, you will lose the last data modification!");
        alert.setContentText(null);

        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(yes, no);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == yes) {
            dataModel.loadRecoveryFile();
        } else if (result.get() == no) {
            event.consume();
        }
    }
}