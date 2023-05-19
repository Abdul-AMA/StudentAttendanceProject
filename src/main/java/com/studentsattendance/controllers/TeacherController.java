package com.studentsattendance.controllers;

import com.studentsattendance.Navigation;
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
    @FXML
    public AnchorPane rootPane;
    public Button teacherButton;
    Navigation navigationn = new Navigation();

        @FXML
        private Button button1;

        @FXML
        private Button button2;

        @FXML
        private Button button3;

        @FXML
        private Button button4;

        @FXML
        private Button button5;

        @FXML
        private Button button6;

        @FXML
        private Button button7;

        @FXML
        private Button button8;

        @FXML
        private Button buttonCreate;

        @FXML
        private Button buttonCreate1;

        @FXML
        private Button buttonCreate3;

        @FXML
        private Button buttonCreate31;

        @FXML
        private Button buttonCreate311;

        @FXML
        private Button buttonCreate32;

        @FXML
        private TableColumn<?, ?> columnDuration;

        @FXML
        private TableColumn<?, ?> columnEmail;

        @FXML
        private TableColumn<?, ?> columnFirstName;

        @FXML
        private TableColumn<?, ?> columnLastName;

        @FXML
        private TableColumn<?, ?> columnLectureClassRome;

        @FXML
        private TableColumn<?, ?> columnLectureDate;

        @FXML
        private TableColumn<?, ?> columnLectureTitle;

        @FXML
        private TableColumn<?, ?> columnMajor;

        @FXML
        private TableColumn<?, ?> columnPhoneNumber;

        @FXML
        private TextField editDuration;

        @FXML
        private TextField editLectureClassRome;

        @FXML
        private TextField editLectureDate;

        @FXML
        private TextField editLectureTitle;

        @FXML
        private TextField email;

        @FXML
        private TextField firstName;

        @FXML
        private TextField lastName;

        @FXML
        private Button logout;

        @FXML
        private TextField major;

        @FXML
        private MenuButton menuButton;

        @FXML
        private MenuButton menuButton1;

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

        @FXML
        private TextField phoneNumber;

        @FXML
        private StackPane stackPane;

        @FXML
        private TableView<?> tableLecture;

        @FXML
        private TableView<?> tableStudent;

        @FXML
        private TextField textDuration;

        @FXML
        private TextField textEmail;

        @FXML
        private TextField textFirstName;

        @FXML
        private TextField textLastName;

        @FXML
        private TextField textLectureClassRome;

        @FXML
        private TextField textLectureDate;

        @FXML
        private TextField textLectureTitle;

        @FXML
        private TextField textMajor;

        @FXML
        private TextField textPhoneNumber;

        @FXML
        void onCreate(ActionEvent event) {

        }



        @FXML
        public void switchPage(ActionEvent event){
            if(event.getSource() == button1){
                page1.setVisible(true);
                page2.setVisible(false);
                page3.setVisible(false);
                page4.setVisible(false);
                page5.setVisible(false);
                page6.setVisible(false);

            } else if (event.getSource() == button2) {
                page1.setVisible(false);
                page2.setVisible(true);
                page3.setVisible(false);
                page4.setVisible(false);
                page5.setVisible(false);
                page6.setVisible(false);
            } else if (event.getSource() == button3) {
                page1.setVisible(false);
                page2.setVisible(false);
                page3.setVisible(true);
                page4.setVisible(false);
                page5.setVisible(false);
                page6.setVisible(false);

            }
            else if (event.getSource() == button4) {
                page1.setVisible(false);
                page2.setVisible(false);
                page3.setVisible(false);
                page4.setVisible(true);
                page5.setVisible(false);
                page6.setVisible(false);

            }
            else if (event.getSource() == button5) {
                page1.setVisible(false);
                page2.setVisible(false);
                page3.setVisible(false);
                page4.setVisible(false);
                page5.setVisible(true);
                page6.setVisible(false);

            }
            else if (event.getSource() == button6) {
                page1.setVisible(false);
                page2.setVisible(false);
                page3.setVisible(false);
                page4.setVisible(false);
                page5.setVisible(false);
                page6.setVisible(true);

            }

        }
    public void hover(){
        button1.setStyle("-fx-background-color:  #D3D3D3; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        button1.setOnMouseEntered(e -> {
            button1.setStyle("-fx-background-color: #89cfff; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        });
        button1.setOnMouseExited(e -> {
            button1.setStyle("-fx-background-color: #D3D3D3; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        });
        button2.setStyle("-fx-background-color:  #D3D3D3; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        button2.setOnMouseEntered(e -> {
            button2.setStyle("-fx-background-color: #89cfff; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        });
        button2.setOnMouseExited(e -> {
            button2.setStyle("-fx-background-color: #D3D3D3; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        });
        button3.setStyle("-fx-background-color:  #D3D3D3; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        button3.setOnMouseEntered(e -> {
            button3.setStyle("-fx-background-color: #89cfff; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        });
        button3.setOnMouseExited(e -> {
            button3.setStyle("-fx-background-color: #D3D3D3; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        });
        button4.setOnMouseEntered(e -> {
            button4.setStyle("-fx-background-color: #89cfff; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        });
        button4.setOnMouseExited(e -> {
            button4.setStyle("-fx-background-color: #D3D3D3; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        });
        button5.setOnMouseEntered(e -> {
            button5.setStyle("-fx-background-color: #89cfff; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        });
        button5.setOnMouseExited(e -> {
            button5.setStyle("-fx-background-color: #D3D3D3; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        });
        button6.setOnMouseEntered(e -> {
            button6.setStyle("-fx-background-color: #89cfff; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        });
        button6.setOnMouseExited(e -> {
            button6.setStyle("-fx-background-color: #D3D3D3; -fx-border-color:  #808080; -fx-border-width:  0px 0px 2px 0px;");
        });
        logout.setOnMouseEntered(e -> {
            logout.setStyle("-fx-background-color: #4997D0;");
        });
        logout.setOnMouseExited(e -> {
            logout.setStyle("-fx-background-color: #0598ff;");
        });
        buttonCreate.setOnMouseEntered(e -> {
            buttonCreate.setStyle("-fx-background-color: #4997D0;");
        });
        buttonCreate.setOnMouseExited(e -> {
            buttonCreate.setStyle("-fx-background-color: #0598ff;");
        });

    }
    public void onLogOut( ) {
        navigationn.navigateTo(stackPane,Navigation.Login_FXML);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hover();
    }
}




