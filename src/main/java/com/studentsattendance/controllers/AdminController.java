package com.studentsattendance.controllers;

import com.studentsattendance.program;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;
    @FXML
    private Button logout;

    @FXML
    private AnchorPane page1;

    @FXML
    private AnchorPane page2;

    @FXML
    private AnchorPane page3;

    public void switchPage(ActionEvent event){
        if(event.getSource() == button1){
            page1.setVisible(true);
            page2.setVisible(false);
            page3.setVisible(false);

        } else if (event.getSource() == button2) {
            page1.setVisible(false);
            page2.setVisible(true);
            page3.setVisible(false);
        } else if (event.getSource() == button3) {
            page1.setVisible(false);
            page2.setVisible(false);
            page3.setVisible(true);

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
        logout.setOnMouseEntered(e -> {
            logout.setStyle("-fx-background-color: #4997D0;");
        });
        logout.setOnMouseExited(e -> {
            logout.setStyle("-fx-background-color: #0598ff;");
        });

    }
    public void logout(){
        logout.setOnAction(e -> {
           System.exit(0);
        });

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hover();
        logout();
    }



}
