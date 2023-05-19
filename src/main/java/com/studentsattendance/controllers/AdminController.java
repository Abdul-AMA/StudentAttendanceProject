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
import javafx.css.Style;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
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

    public TableView<Course> tableCourses;
    public AnchorPane pageDefault;
    public Button buttonPageDefault;
    public Button buttonCreateNewCourse;
    public MenuButton menuButtonEditCourse;
    public TextField textEditCourseId;
    public TextField textEditCourseName;
    public TextField textEditCourseHour;
    public TextField textEditCourseBook;
    public TextField textEditCourseDoctor;
    public TextField textEditCourseDescription;
    @FXML
    private Button buttonCreateCourse;

    @FXML
    private Button buttonShowTeacher;

    @FXML
    private Button buttonEditCourse;
    @FXML
    private Button buttonShowCourses;

    @FXML
    private Button buttonEditTeacher;

    @FXML
    private Button buttonCreateTeacher;

    @FXML
    private Button logout;

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

    ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
    ArrayList<String> menuItemsNames = new ArrayList<String>();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataModel = new DataModel();
        administrator = dataModel.getAdministrator();
        hover();


    }



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

        String style1 = "-fx-background-color: #dad7cd; -fx-text-fill : #588157; -fx-border-color:  #A3B18A; -fx-border-width:  0px 0px 2px 0px;";
        String style2 = "-fx-background-color:  #588157; -fx-text-fill : #dad7cd;-fx-border-color:  #A3B18A; -fx-border-width:  0px 0px 2px 0px;";


        buttonCreateCourse.setStyle(style1);
        buttonCreateCourse.setOnMouseEntered(e -> {
            buttonCreateCourse.setStyle(style2);
        });
        buttonCreateCourse.setOnMouseExited(e -> {
            buttonCreateCourse.setStyle(style1);
        });

        buttonShowCourses.setStyle(style1);
        buttonShowCourses.setOnMouseEntered(e -> {
            buttonShowCourses.setStyle(style2);
        });
        buttonShowCourses.setOnMouseExited(e -> {
            buttonShowCourses.setStyle(style1);
        });

        buttonEditCourse.setStyle(style1);
        buttonEditCourse.setOnMouseEntered(e -> {
            buttonEditCourse.setStyle(style2);
        });
        buttonEditCourse.setOnMouseExited(e -> {
            buttonEditCourse.setStyle(style1);
        });

        buttonCreateTeacher.setStyle(style1);
        buttonCreateTeacher.setOnMouseEntered(e -> {
            buttonCreateTeacher.setStyle(style2);
        });
        buttonCreateTeacher.setOnMouseExited(e -> {
            buttonCreateTeacher.setStyle(style1);
        });

        buttonShowTeacher.setStyle(style1);
        buttonShowTeacher.setOnMouseEntered(e -> {
            buttonShowTeacher.setStyle(style2);
        });
        buttonShowTeacher.setOnMouseExited(e -> {
            buttonShowTeacher.setStyle(style1);
        });

        buttonEditTeacher.setStyle(style1);
        buttonEditTeacher.setOnMouseEntered(e -> {
            buttonEditTeacher.setStyle(style2);
        });
        buttonEditTeacher.setOnMouseExited(e -> {
            buttonEditTeacher.setStyle(style1);
        });

        buttonPageDefault.setStyle(style1);
        buttonPageDefault.setOnMouseEntered(e -> {
            buttonPageDefault.setStyle(style2);
        });
        buttonPageDefault.setOnMouseExited(e -> {
            buttonPageDefault.setStyle(style1);
        });

        logout.setStyle(style1);
        logout.setOnMouseEntered(e -> {
            logout.setStyle(style2);
        });
        logout.setOnMouseExited(e -> {
            logout.setStyle(style1);
        });
    }



    public void onPageDefault(ActionEvent event) {
        setAllNotVisible();
        pageDefault.setVisible(true);
    }
    public void onCreateCourse( ){
        setAllNotVisible();
        page1.setVisible(true);
        textCourseId.clear();
        textCourseName.clear();
        textCourseDoctor.clear();
        textCourseHour.clear();
        textCourseBook.clear();
        textCourseDescription.clear();

    }
    public void onShowCourses(ActionEvent event) {
        setAllNotVisible();
        page2.setVisible(true);
        fillCoursesTable();
        tableCourses.refresh();


    }
    public void onEditCourse() {
        setAllNotVisible();
        page3.setVisible(true);
        menuButtonEditCourse.getItems().clear();
        menuItems.clear();
        menuItemsNames.clear();
        menuButtonEditCourse.setText("Courses");
        for (int i = 0; i < administrator.getCourseList().size(); i++) {
            menuItems.add(new MenuItem(administrator.getCourseList().get(i).getCourseName()));
            menuItemsNames.add(administrator.getCourseList().get(i).getCourseName());
            int finalI = i;
            menuItems.get(i).setOnAction(e -> handleMenuItem(menuItemsNames.get(finalI)));

        }
        menuButtonEditCourse.getItems().addAll(menuItems);
        textEditCourseId.clear();
        textEditCourseName.clear();
        textEditCourseDoctor.clear();
        textEditCourseBook.clear();
        textEditCourseDescription.clear();
        textEditCourseHour.clear();



    }
    public void onCreateTeacher(ActionEvent event) {
        setAllNotVisible();
        page4.setVisible(true);
    }
    public void onShowTeacher(ActionEvent event) {
        setAllNotVisible();
        page5.setVisible(true);
    }
    public void onEditTeacher(ActionEvent event) {
        setAllNotVisible();
        page6.setVisible(true);
    }
    public void onLogOut( ) {
        navigation.navigateTo(stackPane,Navigation.Login_FXML);

    }

    public void onCreateNewCourse(ActionEvent event) {
        Course course = new Course(textCourseId.getText(),textCourseName.getText(),textCourseDoctor.getText(),Integer.parseInt(textCourseHour.getText()),
                textCourseBook.getText(),textCourseDescription.getText());
        administrator.addCourse(course);
        onCreateCourse();
    }



    public void onCreate(ActionEvent event) {
    }

    public void onButtonEditCourse(ActionEvent event) {
        if (!menuButtonEditCourse.getText().equals("Courses")){
            int index = administrator.getCourseIndexByName(menuButtonEditCourse.getText());
            Course course = administrator.courseList.get(index);
            if (!textEditCourseId.getText().isEmpty()){
                course.setCourseId(textEditCourseId.getText());
            }
            if (!textEditCourseName.getText().isEmpty()){
                course.setCourseName(textEditCourseName.getText());
            }
            if (!textEditCourseDoctor.getText().isEmpty()){
                course.setDoctor(textEditCourseDoctor.getText());
            }
            if (!textEditCourseBook.getText().isEmpty()){
                course.setBook(textEditCourseBook.getText());
            }
            if (!textEditCourseDescription.getText().isEmpty()){
                course.setDescription(textEditCourseDescription.getText());
            }
            if (!textEditCourseHour.getText().isEmpty()){
                course.setCourseHours(Integer.parseInt(textEditCourseHour.getText()));
            }
            onEditCourse();

        }
    }

    public void onButtonDeleteCourse(ActionEvent event) {
        if (!menuButtonEditCourse.getText().equals("Courses")){
            int index = administrator.getCourseIndexByName(menuButtonEditCourse.getText());
            administrator.courseList.remove(administrator.courseList.get(index));
        }
        onEditCourse();

    }

    private void handleMenuItem(String menuItemText) {
            menuButtonEditCourse.setText(menuItemText);

    }

    public void fillCoursesTable(){
        columnCourseId.setCellValueFactory(new PropertyValueFactory<Course,Integer>("courseId"));
        columnCourseName.setCellValueFactory(new PropertyValueFactory<Course,String>("courseName"));
        columnCourseDoctor.setCellValueFactory(new PropertyValueFactory<Course,String>("courseDoctor"));
        columnCourseHours.setCellValueFactory(new PropertyValueFactory<Course,Integer>("courseHours"));
        columnCourseBook.setCellValueFactory(new PropertyValueFactory<Course,String>("book"));
        columnCourseDescription.setCellValueFactory(new PropertyValueFactory<Course,String>("description"));
        columnCourseMaximumAbsence.setCellValueFactory(new PropertyValueFactory<Course,Integer>("maximumAbsence"));
        ObservableList<Course> observableListCourses = FXCollections.observableArrayList(administrator.getCourseList());
        tableCourses.setItems(observableListCourses);
    }
}
