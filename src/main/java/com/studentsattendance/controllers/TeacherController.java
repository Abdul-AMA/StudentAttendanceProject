package com.studentsattendance.controllers;

import com.studentsattendance.Navigation;
import com.studentsattendance.models.Administrator;
import com.studentsattendance.models.DataModel;
import com.studentsattendance.program;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {

    public Button buttonPageDefault;
    public Button buttonRegisterStudent;
    public Button buttonShowStudents;
    public Button buttonEditStudent;
    public Button buttonAddLecture;
    public Button buttonShowLectures;
    public Button buttonEditLectures;
    public Button buttonRegisterAttendance;
    public Button buttonReports;
    public Button logout;
    Navigation navigationn = new Navigation();
    DataModel dataModel;
    Administrator administrator;
    @FXML
    public StackPane StackPane;
    public AnchorPane pageDefault;
    @FXML
    private AnchorPane page1;

    @FXML
    private AnchorPane page2;

    @FXML
    private AnchorPane page3;

    @FXML
    private AnchorPane page4;

    @FXML
    private AnchorPane page5;

    @FXML
    private AnchorPane page6;



    public void setAllNotVisible() {
        page1.setVisible(false);
        page2.setVisible(false);
        page3.setVisible(false);
        page4.setVisible(false);
        page5.setVisible(false);
        page6.setVisible(false);
        pageDefault.setVisible(false);

    }



    public void hover(){
        buttonEffect(buttonPageDefault);
        buttonEffect(buttonRegisterStudent);
        buttonEffect(buttonShowStudents);
        buttonEffect(buttonEditStudent);
        buttonEffect(buttonAddLecture);
        buttonEffect(buttonShowLectures);
        buttonEffect(buttonEditLectures);
        buttonEffect(buttonRegisterAttendance);
        buttonEffect(buttonReports);
        buttonEffect(logout);

    }

    public void buttonEffect(Button button){
        String style1 = "-fx-background-color: #dad7cd; -fx-text-fill : #588157; -fx-border-color:  #A3B18A; -fx-border-width:  0px 0px 2px 0px;";
        String style2 = "-fx-background-color:  #588157; -fx-text-fill : #dad7cd;-fx-border-color:  #A3B18A; -fx-border-width:  0px 0px 2px 0px;";

        button.setStyle(style1);
        button.setOnMouseEntered(e -> {
            button.setStyle(style2);
        });
        button.setOnMouseExited(e -> {
            button.setStyle(style1);
        });
    }
    public void onLogOut( ) {
        navigationn.navigateTo(StackPane,Navigation.Login_FXML);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hover();
    }



    public void onPageDefault(ActionEvent actionEvent) {
        setAllNotVisible();
        pageDefault.setVisible(true);
    }
    public void onRegisterStudent(ActionEvent actionEvent) {
        setAllNotVisible();
        page1.setVisible(true);
    }
    public void onShowStudents(ActionEvent actionEvent) {
        setAllNotVisible();
        page2.setVisible(true);
    }
    public void onEditStudent(ActionEvent actionEvent) {
        setAllNotVisible();
        page3.setVisible(true);
    }
    public void onAddLecture(ActionEvent actionEvent) {
        setAllNotVisible();
        page4.setVisible(true);
    }
    public void onEditLectures(ActionEvent actionEvent) {
        setAllNotVisible();
        page5.setVisible(true);
    }
    public void onShowLectures(ActionEvent actionEvent) {
        setAllNotVisible();
        page6.setVisible(true);
    }
    public void onRegisterAttendance(ActionEvent actionEvent) {
    }
    public void onReports(ActionEvent actionEvent) {
    }



    public void onCreate(ActionEvent actionEvent) {
    }


}




