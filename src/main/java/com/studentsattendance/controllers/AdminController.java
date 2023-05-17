package com.studentsattendance.controllers;

import com.studentsattendance.Navigation;
import com.studentsattendance.models.Administrator;
import com.studentsattendance.models.Course;
import com.studentsattendance.models.DataModel;
import com.studentsattendance.program;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public StackPane stackPane;
    public TableColumn<Course, Integer> columnCourseId;
    public TableColumn<Course,String> columnCourseName;
    public TableColumn<Course,String> columnCourseDoctor;
    public TableColumn<Course,Integer> columnCourseHours;
    public TableColumn<Course,String> columnCourseBook;
    public TableColumn<Course,String> columnCourseDescription;
    public TableColumn<Course,Integer> columnCourseMaximumAbsence;
    public TableColumn<Course,String> columnCourseStudents;
    public TableColumn<Course,String> columnCourseLectures;
    public TableView<Course> tableCourses;
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
    private Button logout;
    @FXML
    private Button buttonCreate11;
    @FXML
    private TextField textCourseBook;

    @FXML
    private TextField textCourseDescription;

    @FXML
    private TextField textCourseHour;

    @FXML
    private TextField textCourseId;

    @FXML
    private TextField textCourseName;
    @FXML
    private TextField textCourseDoctor;



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

    Navigation navigation = new Navigation();

    DataModel dataModel;
    Administrator administrator;

    ObservableList<Course> observableListCourses ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataModel = new DataModel();
        administrator = dataModel.getAdministrator();
        observableListCourses = FXCollections.observableArrayList(administrator.getCourseList());
        columnCourseId.setCellValueFactory(new PropertyValueFactory<Course,Integer>("courseId"));
        columnCourseName.setCellValueFactory(new PropertyValueFactory<Course,String>("courseName"));
        columnCourseDoctor.setCellValueFactory(new PropertyValueFactory<Course,String>("courseDoctor"));
        columnCourseHours.setCellValueFactory(new PropertyValueFactory<Course,Integer>("courseHours"));
        columnCourseBook.setCellValueFactory(new PropertyValueFactory<Course,String>("book"));
        columnCourseDescription.setCellValueFactory(new PropertyValueFactory<Course,String>("description"));
        columnCourseMaximumAbsence.setCellValueFactory(new PropertyValueFactory<Course,Integer>("maximumAbsence"));

        tableCourses.setItems(observableListCourses);
        hover();

    }


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

    public void onCreateCourse(){

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

    public void onCreate() {
//            public Course(String courseId, String courseName, int courseHours, String book, String description) {
        Course course = new Course(textCourseId.getText(),textCourseName.getText(),textCourseDoctor.getText(),Integer.parseInt(textCourseHour.getText()),
                textCourseBook.getText(),textCourseDescription.getText());
        administrator.addCourse(course);
    }





    public void onLogOut( ) {
        navigation.navigateTo(stackPane,Navigation.Login_FXML);
    }
}
