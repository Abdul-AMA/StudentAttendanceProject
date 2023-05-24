package com.studentsattendance.controllers;

import com.studentsattendance.Navigation;
import com.studentsattendance.models.*;
import com.studentsattendance.program;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class TeacherController implements Initializable {

    public MenuButton menuButtonEditStudent;
    @FXML
    private StackPane StackPane;

    @FXML
    private Text TeacherName;

    @FXML
    private Button buttonAddLecture;

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
    private Button buttonCreateNewStudent;

    @FXML
    private Button buttonEditLectures;

    @FXML
    private Button buttonEditStudent;

    @FXML
    private Button buttonPageDefault;

    @FXML
    private Button buttonRegisterAttendance;

    @FXML
    private Button buttonRegisterStudent;

    @FXML
    private Button buttonReports;

    @FXML
    private Button buttonShowLectures;

    @FXML
    private Button buttonShowStudents;

    @FXML
    private TableColumn<Lecture, Double> columnDuration;

    @FXML
    private TableColumn<Student, String> columnEmail;

    @FXML
    private TableColumn<Student, String> columnFirstName;

    @FXML
    private TableColumn<Student, String> columnLastName;

    @FXML
    private TableColumn<Lecture, String> columnLectureClassRome;

    @FXML
    private TableColumn<Lecture, Date> columnLectureDate;

    @FXML
    private TableColumn<Lecture, String> columnLectureTitle;

    @FXML
    private TableColumn<Student, String> columnMajor;

    @FXML
    private TableColumn<Student, Integer> columnPhoneNumber;

    @FXML
    private TextField editDuration;

    @FXML
    private TextField editLectureClassRome;

    @FXML
    private TextField editLectureDate;

    @FXML
    private TextField editLectureTitle;

    @FXML
    private Button empty1;

    @FXML
    private Button empty2;

    @FXML
    private Button logout;

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
    private AnchorPane pageDefault;

    @FXML
    private TableView<Lecture> tableLecture;

    @FXML
    private TableView<Student> tableStudent;

    @FXML
    private TextField textAddEmail;

    @FXML
    private TextField textAddFirstName;

    @FXML
    private TextField textAddLastName;

    @FXML
    private TextField textAddMajor;

    @FXML
    private TextField textAddPhoneNumber;

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
    private TextField textLectureTitle;

    @FXML
    private TextField textMajor;

    @FXML
    private TextField textPhoneNumber;
    @FXML
    private DatePicker textLectureDate;
    Navigation navigationn = new Navigation();
    DataModel dataModel;
    Administrator administrator;
    TeacherAssistant teacherAssistant;

    ArrayList<MenuItem> menuItemsStudents = new ArrayList<MenuItem>();
    ArrayList<String> menuItemsStudentsNames = new ArrayList<String>();

    ArrayList<MenuItem> menuItemsLectures = new ArrayList<MenuItem>();
    ArrayList<String> menuItemsLecturesNames = new ArrayList<String>();





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
    public void onLogOut(ActionEvent event ) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Do you want to save the changed data?");
        alert.setContentText(null);

        ButtonType save = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.FINISH);
        ButtonType do_not_save = new ButtonType("Don't Save", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(save, cancel, do_not_save);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == save) {
            dataModel.save_date();
            navigationn.navigateTo(StackPane,Navigation.Login_FXML);
        } else if (result.get() == do_not_save) {
            navigationn.navigateTo(StackPane,Navigation.Login_FXML);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataModel = new DataModel();
        administrator = dataModel.getAdministrator();
        teacherAssistant = administrator.getTeacherAssistantList().get(IndexHolder.getInstance().getCurrentIndex());
        TeacherName.setText("Teacher: " + teacherAssistant.getUsername());

        hover();
    }



    public void onPageDefault(ActionEvent actionEvent) {
        setAllNotVisible();
        pageDefault.setVisible(true);
    }
    public void onRegisterStudent() {
        setAllNotVisible();
        page1.setVisible(true);
        setAllNotVisible();
        page1.setVisible(true);
        textAddFirstName.clear();
        textAddLastName.clear();
        textAddEmail.clear();
        textAddMajor.clear();
        textAddPhoneNumber.clear();
    }
    public void onShowStudents() {
        setAllNotVisible();
        page2.setVisible(true);
        fillStudentTable();
        tableStudent.refresh();
    }
    public void onEditStudent() {
        setAllNotVisible();
        page3.setVisible(true);

        menuButtonEditStudent.getItems().clear();
        menuItemsStudents.clear();
        menuItemsStudentsNames.clear();
        menuButtonEditStudent.setText("Student ID");
        for (int i = 0; i < teacherAssistant.getCourse().getStudentsList().size(); i++) {
            menuItemsStudents.add(new MenuItem(teacherAssistant.getCourse().getStudentsList().get(i).getUsername()));
            menuItemsStudentsNames.add(teacherAssistant.getCourse().getStudentsList().get(i).getUsername());
            int finalI = i;
            menuItemsStudents.get(i).setOnAction(e -> handleMenuItem(menuItemsStudentsNames.get(finalI) , menuButtonEditStudent));


        }
        menuButtonEditStudent.getItems().addAll(menuItemsStudents);

        textFirstName.clear();
        textLastName.clear();
        textEmail.clear();
        textMajor.clear();
        textPhoneNumber.clear();

    }
    public void onAddLecture() {
        setAllNotVisible();
        page4.setVisible(true);
        textLectureTitle.clear();
        textLectureClassRome.clear();
        textDuration.clear();

    }
    public void onEditLectures() {
        setAllNotVisible();
        page6.setVisible(true);
    }
    public void onShowLectures( ) {
        setAllNotVisible();
        page5.setVisible(true);
        fillLectureTable();
        tableLecture.refresh();
    }
    public void onRegisterAttendance( ) {
    }
    public void onReports( ) {
    }
    public void onCreateNewStudent(ActionEvent event){
        Student student = new Student(textAddFirstName.getText(), textAddLastName.getText(),textAddEmail.getText(), textAddMajor.getText(), Integer.parseInt(textAddPhoneNumber.getText()));
        teacherAssistant.addStudent(student);
        onRegisterStudent();

    }

    public void onCreatNewLecture(ActionEvent event) {
        Lecture lecture = new Lecture(textLectureTitle.getText(), textLectureClassRome.getText(), Double.parseDouble(textDuration.getText()), new Date());
        teacherAssistant.addLecture(lecture);
        onAddLecture();
//        System.out.println(textLectureDate.getValue().toString());

    }


//
    public void fillStudentTable(){
        columnFirstName.setCellValueFactory(new PropertyValueFactory<Student,String>("firstName"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<Student,String>("lastName"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        columnMajor.setCellValueFactory(new PropertyValueFactory<Student,String>("major"));
        columnPhoneNumber.setCellValueFactory(new PropertyValueFactory<Student,Integer>("phoneNumber"));

        ObservableList<Student> observableListStudent = FXCollections.observableArrayList(teacherAssistant.getStudentList());
        tableStudent.setItems(observableListStudent);
    }
    public void fillLectureTable(){
        columnLectureTitle.setCellValueFactory(new PropertyValueFactory<Lecture,String>("lectureTitle"));
        columnLectureClassRome.setCellValueFactory(new PropertyValueFactory<Lecture,String>("lectureClassRome"));
        columnDuration.setCellValueFactory(new PropertyValueFactory<Lecture,Double>("duration"));
        columnLectureDate.setCellValueFactory(new PropertyValueFactory<Lecture, Date>("lectureDate"));


        ObservableList<Lecture> observableListLecture = FXCollections.observableArrayList(teacherAssistant.getLecturesList());
        tableLecture.setItems(observableListLecture);
    }



    public void onCreate(ActionEvent actionEvent) {
    }

    private void handleMenuItem(String menuItemText, MenuButton menuButton) {
        menuButton.setText(menuItemText);
    }

    public void onButtonEditStudent(ActionEvent event) {
        if (!menuButtonEditStudent.getText().equals("Courses")){
            Student student = teacherAssistant.getCourse().getStudentById(menuButtonEditStudent.getText());
            if (!textFirstName.getText().isEmpty()){
                student.setFirstName(textFirstName.getText());
            }
            if (!textLastName.getText().isEmpty()){
                student.setLastName(textLastName.getText());
            }
            if (!textEmail.getText().isEmpty()){
                student.setEmail(textEmail.getText());
            }
            if (!textMajor.getText().isEmpty()){
                student.setMajor(textMajor.getText());
            }
            if (!textPhoneNumber.getText().isEmpty()){
                student.setPhoneNumber(Integer.parseInt(textPhoneNumber.getText()));
            }
            onEditStudent();

        }
    }

    public void onButtonDeleteStudent(ActionEvent event) {
        if (!menuButtonEditStudent.getText().equals("Courses")){
            teacherAssistant.getCourse().getStudentsList().remove(teacherAssistant.getCourse().getStudentById(menuButtonEditStudent.getText()));
        }
        onEditStudent();

    }


}




