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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {

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
    private TableColumn<Lecture, String> columnLectureDate;

    @FXML
    private TableColumn<Lecture, String> columnLectureTitle;

    @FXML
    private TableColumn<Student, String> columnMajor;

    @FXML
    private TableColumn<Student, Long> columnPhoneNumber;

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
    public void onRegisterStudent(ActionEvent actionEvent) {
        setAllNotVisible();
        page1.setVisible(true);
    }
    public void onShowStudents(ActionEvent actionEvent) {
        setAllNotVisible();
        page2.setVisible(true);
        fillStudentTable();
        tableStudent.refresh();
        deleteRowsStudent();
        tableStudent.refresh();
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
        page6.setVisible(true);
    }
    public void onShowLectures(ActionEvent actionEvent) {
        setAllNotVisible();
        page5.setVisible(true);
        fillLectureTable();
        tableLecture.refresh();
        deleteRowsLectures();
        tableLecture.refresh();
    }
    public void onRegisterAttendance(ActionEvent actionEvent) {
    }
    public void onReports(ActionEvent actionEvent) {
    }
    public void onCreateNewStudent(ActionEvent event){
        Student student = new Student(textAddFirstName.getText(), textAddLastName.getText(),textAddEmail.getText(), textAddMajor.getText(), Long.parseLong(textAddPhoneNumber.getText()));
        teacherAssistant.addStudent(student);
        onCreatStudent();



    }

    public void onCreatNewLecture(ActionEvent event) {
        Lecture lecture = new Lecture(textLectureTitle.getText(), textLectureClassRome.getText(), Double.parseDouble(textDuration.getText()), textLectureDate.getValue().toString());
        teacherAssistant.addLecture(lecture);
        onCreatLecture();
    }
    public void onCreatStudent(){
        setAllNotVisible();
        page1.setVisible(true);
        textAddFirstName.clear();
        textAddLastName.clear();
        textAddEmail.clear();
        textAddMajor.clear();
        textAddPhoneNumber.clear();
    }
    public void onCreatLecture(){
        setAllNotVisible();
        page4.setVisible(true);
        textLectureTitle.clear();
        textLectureClassRome.clear();
        textDuration.clear();
        textLectureDate.setValue(null);


    }
//
    public void fillStudentTable(){
        columnFirstName.setCellValueFactory(new PropertyValueFactory<Student,String>("firstName"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<Student,String>("lastName"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        columnMajor.setCellValueFactory(new PropertyValueFactory<Student,String>("major"));
        columnPhoneNumber.setCellValueFactory(new PropertyValueFactory<Student,Long>("phoneNumber"));

        ObservableList<Student> observableListStudent = FXCollections.observableArrayList(teacherAssistant.getStudentList());
        tableStudent.setItems(observableListStudent);
        //---------------------------------------
        StringConverter<Integer> integerConverter = new StringConverter<>() {
            @Override
            public String toString(Integer value) {
                if (value == null) {
                    return "";
                }
                return value.toString();
            }

            @Override
            public Integer fromString(String string) {
                if (string == null || string.trim().isEmpty()) {
                    return 0;
                }
                return Integer.parseInt(string);
            }
        };

// Custom StringConverter for Double values
        StringConverter<Double> doubleConverter = new StringConverter<>() {
            @Override
            public String toString(Double value) {
                if (value == null) {
                    return "";
                }
                return value.toString();
            }

            @Override
            public Double fromString(String string) {
                if (string == null || string.trim().isEmpty()) {
                    return 0.0;
                }
                return Double.parseDouble(string);
            }
        };
        // Custom StringConverter for Long values
        StringConverter<Long> longConverter = new StringConverter<>() {
            @Override
            public String toString(Long value) {
                if (value == null) {
                    return "";
                }
                return value.toString();
            }

            @Override
            public Long fromString(String string) {
                if (string == null || string.trim().isEmpty()) {
                    return 0L;
                }
                return Long.parseLong(string);
            }
        };
        //---------------------------------------

        tableStudent.setEditable(true);
        columnFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        columnLastName.setCellFactory(TextFieldTableCell.forTableColumn());
        columnEmail.setCellFactory(TextFieldTableCell.forTableColumn());
        columnMajor.setCellFactory(TextFieldTableCell.forTableColumn());
        columnPhoneNumber.setCellFactory(TextFieldTableCell.forTableColumn(longConverter));

    }
    public void fillLectureTable(){
        columnLectureTitle.setCellValueFactory(new PropertyValueFactory<Lecture,String>("lectureTitle"));
        columnLectureClassRome.setCellValueFactory(new PropertyValueFactory<Lecture,String>("lectureClassRome"));
        columnDuration.setCellValueFactory(new PropertyValueFactory<Lecture,Double>("duration"));
        columnLectureDate.setCellValueFactory(cellData -> {
            Lecture lecture = cellData.getValue();
            return lecture.dateStringProperty();
        });

        ObservableList<Lecture> observableListLecture = FXCollections.observableArrayList(teacherAssistant.getLecturesList());
        tableLecture.setItems(observableListLecture);
        //---------------------------------------
        StringConverter<Integer> integerConverter = new StringConverter<>() {
            @Override
            public String toString(Integer value) {
                if (value == null) {
                    return "";
                }
                return value.toString();
            }

            @Override
            public Integer fromString(String string) {
                if (string == null || string.trim().isEmpty()) {
                    return 0;
                }
                return Integer.parseInt(string);
            }
        };

// Custom StringConverter for Double values
        StringConverter<Double> doubleConverter = new StringConverter<>() {
            @Override
            public String toString(Double value) {
                if (value == null) {
                    return "";
                }
                return value.toString();
            }

            @Override
            public Double fromString(String string) {
                if (string == null || string.trim().isEmpty()) {
                    return 0.0;
                }
                return Double.parseDouble(string);
            }
        };
        //---------------------------------------

        tableLecture.setEditable(true);
        columnLectureTitle.setCellFactory(TextFieldTableCell.forTableColumn());
        columnLectureClassRome.setCellFactory(TextFieldTableCell.forTableColumn());
        columnDuration.setCellFactory(TextFieldTableCell.forTableColumn(doubleConverter));
        columnLectureDate.setCellFactory(TextFieldTableCell.forTableColumn());

    }






    public void onCreate(ActionEvent actionEvent) {
    }


    public void onEditStudentFirstName(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent) {
        Student student = tableStudent.getSelectionModel().getSelectedItem();
        student.setFirstName(studentStringCellEditEvent.getNewValue());
    }

    public void onEditStudentLastName(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent) {
        Student student = tableStudent.getSelectionModel().getSelectedItem();
        student.setLastName(studentStringCellEditEvent.getNewValue());
    }

    public void onEditStudentEmail(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent) {
        Student student = tableStudent.getSelectionModel().getSelectedItem();
        student.setEmail(studentStringCellEditEvent.getNewValue());
    }

    public void onEditStudentMajor(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent) {
        Student student = tableStudent.getSelectionModel().getSelectedItem();
        student.setMajor(studentStringCellEditEvent.getNewValue());
    }

    public void onEditStudentPhoneNumber(TableColumn.CellEditEvent<Student, Long> studentIntegerCellEditEvent) {
        Student student = tableStudent.getSelectionModel().getSelectedItem();
        student.setPhoneNumber(studentIntegerCellEditEvent.getNewValue());
    }

    public void onEditLectureTitle(TableColumn.CellEditEvent<Lecture, String> lectureStringCellEditEvent) {
        Lecture lecture = tableLecture.getSelectionModel().getSelectedItem();
        lecture.setLectureTitle(lectureStringCellEditEvent.getNewValue());
    }

    public void onEditLectureClassRome(TableColumn.CellEditEvent<Lecture, String> lectureStringCellEditEvent) {
        Lecture lecture = tableLecture.getSelectionModel().getSelectedItem();
        lecture.setLectureClassRome(lectureStringCellEditEvent.getNewValue());
    }

    public void onEditLectureDuration(TableColumn.CellEditEvent<Lecture, Double> lectureDoubleCellEditEvent) {
        Lecture lecture = tableLecture.getSelectionModel().getSelectedItem();
        lecture.setDuration(lectureDoubleCellEditEvent.getNewValue());
    }

    public void onEditLectureDate(TableColumn.CellEditEvent<Lecture, String> lectureStringCellEditEvent) {
        Lecture lecture = tableLecture.getSelectionModel().getSelectedItem();
        lecture.setDateString(lectureStringCellEditEvent.getNewValue());
    }
    public void deleteRowsStudent() {
        // في جزء الكود حيث تتم معالجة حدث الضغط على زر Delete
        tableStudent.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DELETE) {
                // الحصول على الصف المحدد في الـ TableView
                Student student = tableStudent.getSelectionModel().getSelectedItem();

                // التأكد من وجود صف محدد
                if (student != null) {
                    // إنشاء مربع حوار التأكيد
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("تأكيد الحذف");
                    alert.setHeaderText(null);
                    alert.setContentText("هل أنت متأكد من رغبتك في حذف هذا الصف؟");

                    // إضافة أزرار لمربع الحوار
                    ButtonType deleteButton = new ButtonType("حذف", ButtonBar.ButtonData.OK_DONE);
                    ButtonType cancelButton = new ButtonType("إلغاء", ButtonBar.ButtonData.CANCEL_CLOSE);
                    alert.getButtonTypes().setAll(deleteButton, cancelButton);

                    // عرض مربع الحوار وانتظار الاستجابة
                    Optional<ButtonType> result = alert.showAndWait();

                    // التحقق من الاستجابة
                    if (result.isPresent() && result.get() == deleteButton) {
                        // قم بتنفيذ عملية الحذف هنا
                        tableStudent.getItems().remove(student);
                        teacherAssistant.removeStudent(student);
                    }
                }
            }
        });
    }
    public void deleteRowsLectures() {
        // في جزء الكود حيث تتم معالجة حدث الضغط على زر Delete
        tableLecture.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DELETE) {
                // الحصول على الصف المحدد في الـ TableView
                Lecture lecture = tableLecture.getSelectionModel().getSelectedItem();

                // التأكد من وجود صف محدد
                if (lecture != null) {
                    // إنشاء مربع حوار التأكيد
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("تأكيد الحذف");
                    alert.setHeaderText(null);
                    alert.setContentText("هل أنت متأكد من رغبتك في حذف هذا الصف؟");

                    // إضافة أزرار لمربع الحوار
                    ButtonType deleteButton = new ButtonType("حذف", ButtonBar.ButtonData.OK_DONE);
                    ButtonType cancelButton = new ButtonType("إلغاء", ButtonBar.ButtonData.CANCEL_CLOSE);
                    alert.getButtonTypes().setAll(deleteButton, cancelButton);

                    // عرض مربع الحوار وانتظار الاستجابة
                    Optional<ButtonType> result = alert.showAndWait();

                    // التحقق من الاستجابة
                    if (result.isPresent() && result.get() == deleteButton) {
                        // قم بتنفيذ عملية الحذف هنا
                        tableLecture.getItems().remove(lecture);
                        teacherAssistant.removeLecture(lecture);
                    }
                }
            }
        });
    }

    public void onButtonEditStudent(ActionEvent event) {
    }

    public void onButtonDeleteStudent(ActionEvent event) {
    }
}




