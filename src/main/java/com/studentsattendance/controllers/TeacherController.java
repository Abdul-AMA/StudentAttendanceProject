package com.studentsattendance.controllers;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.*;
import com.google.zxing.common.*;
import com.studentsattendance.Navigation;
import com.studentsattendance.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

import static javafx.scene.paint.Color.*;

public class TeacherController implements Initializable {
    public RadioButton radioMale;
    public RadioButton radioFemale;
    public ToggleGroup group;
    public TextField textAddAddress;
    public FileChooser fileChooserSave;

    public ListView<String> listViewAttendance = new ListView<>();
    public TextField textEnterForAttendance;
    public Button buttonImportXLS;
    public Button buttonDoneAttendance;
    public Label labelStudent;
    public AnchorPane page7;
    public TableView<LectureAttendance> tableStudentAttendance;
    public AnchorPane page8;
    public TableView<LectureReport> tableLectureReport;
    public TableColumn<LectureReport, String> columnLectureReportStudentId;
    public TableColumn<LectureReport, String> columnLectureReportStudentName;
    public TableColumn<LectureReport, Boolean> columnLectureReportStatus;
    public TableColumn<LectureReport, String> columnLectureReportTime;
    public TextField textAttendancePercentage;
    public TextField textAttendanceNumber;
    public TextField textLectureReportTitle;
    public AnchorPane page9;
    public TableView<Student> tableStudentDelete;
    public TableColumn<Student, String> columnID1;
    public TableColumn<Student, String> columnFirstName1;
    public TableColumn<Student, String> columnEmail1;
    public TableColumn<Student, String> columnLastName1;
    public TableColumn<Student, String> columnMajor1;
    public TableColumn<Student, String> columnAddress1;
    public TableColumn<Student, Long> columnPhoneNumber1;
    public Button buttonReportBad;
    public Button buttonExportBad;
    public TextField textAttendancePercentageS;
    public TextField textAttendanceNumberS;
    public TextField textStudentReportName;
    @FXML
    private StackPane StackPane;
    @FXML
    private Text TeacherName;
    @FXML
    private Button buttonAddLecture;
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
    public TableColumn<LectureAttendance, String> columnStudentAttendanceLectureName;
    public TableColumn<LectureAttendance, String> columnStudentAttendanceLectureDate;
    public TableColumn<LectureAttendance, Boolean> columnStudentAttendanceStatus;
    public TableColumn<LectureAttendance, String> columnStudentAttendanceTime;

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
    private TableColumn<Student, String> columnID;
    @FXML
    private TableColumn<Student, String> columnAddress;
    @FXML
    private Button logout;
    @FXML
    private AnchorPane page1;
    @FXML
    private AnchorPane page2;
    @FXML
    private AnchorPane page4;
    @FXML
    private AnchorPane page5;
    @FXML
    public AnchorPane page6;
    @FXML
    private AnchorPane pageDefault;
    public MenuButton menuAddAttendance;
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
    private TextField textLectureClassRome;
    @FXML
    private TextField textLectureTitle;
    @FXML
    private DatePicker textLectureDate;
    ArrayList<MenuItem> menuItemsLectures = new ArrayList<MenuItem>();
    ArrayList<String> menuItemsLecturesNames = new ArrayList<String>();
    Navigation navigation = new Navigation();
    DataModel dataModel;
    Administrator administrator;
    TeacherAssistant teacherAssistant;
    Set<String> scannedCodes = new HashSet<>();

    //-----------------------------------------
    public void setAllNotVisible() {
        page1.setVisible(false);
        page2.setVisible(false);
        page4.setVisible(false);
        page5.setVisible(false);
        page6.setVisible(false);
        page7.setVisible(false);
        page8.setVisible(false);
        page9.setVisible(false);
        pageDefault.setVisible(false);

    }

    public void hover() {
        buttonEffect(buttonPageDefault);
        buttonEffect(buttonRegisterStudent);
        buttonEffect(buttonShowStudents);
        buttonEffect(buttonAddLecture);
        buttonEffect(buttonShowLectures);
        buttonEffect(buttonRegisterAttendance);
        buttonEffect(buttonExportBad);
        buttonEffect(buttonReportBad);
        buttonEffect(logout);

    }

    public void buttonEffect(Button button) {
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

    public void onLogOut() {
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
            navigation.navigateTo(StackPane, Navigation.Login_FXML);
        } else if (result.get() == do_not_save) {
            navigation.navigateTo(StackPane, Navigation.Login_FXML);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataModel = new DataModel();
        administrator = dataModel.getAdministrator();
        teacherAssistant = administrator.getTeacherAssistantList().get(IndexHolder.getInstance().getCurrentIndex());
        TeacherName.setText(teacherAssistant.getUsername());
        hover();
    }

    public void onPageDefault() {
        setAllNotVisible();
        pageDefault.setVisible(true);
    }

    public void onRegisterStudent() {
        setAllNotVisible();
        page1.setVisible(true);
        textAddFirstName.clear();
        textAddLastName.clear();
        textAddEmail.clear();
        textAddMajor.clear();
        textAddAddress.clear();
        textAddPhoneNumber.clear();
    }

    public void onShowStudents() {
        setAllNotVisible();
        page2.setVisible(true);
        fillStudentTable();
        tableStudent.refresh();
        deleteRowsStudent();
        tableStudent.refresh();
        tableStudent.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                setAllNotVisible();
                page7.setVisible(true);

                String selectedItem = tableStudent.getSelectionModel().getSelectedItem().getUsername();
                Student student = teacherAssistant.getCourse().getStudentById(selectedItem);
                textStudentReportName.setText(student.getFirstName() +" " + student.getLastName());
                textAttendancePercentageS.setText(String.format("%%%.1f", teacherAssistant.getCourse().getStudentStatistics(student)));
                textAttendanceNumberS.setText(String.format("%d", teacherAssistant.getCourse().getStudentAttendantLectures(student).size()));
                fillStudentReport(student);
                tableStudent.refresh();

            }
        });
    }

    public void onAddLecture() {
        setAllNotVisible();
        page4.setVisible(true);
        textLectureTitle.clear();
        textLectureClassRome.clear();
        textDuration.clear();
        textLectureDate.setValue(null);

    }

    public void onShowLectures() {
        setAllNotVisible();
        page5.setVisible(true);
        fillLectureTable();
        tableLecture.refresh();
        deleteRowsLectures();
        showLecturesStatistics();
        tableLecture.refresh();
    }

    public void onRegisterAttendance() {
        setAllNotVisible();
        page6.setVisible(true);


        labelStudent.setText("");
        textEnterForAttendance.clear();

        menuAddAttendance.getItems().clear();
        menuItemsLectures.clear();
        menuItemsLecturesNames.clear();
        for (int i = 0; i < teacherAssistant.getCourse().getLecturesList().size(); i++) {
            menuItemsLectures.add(new MenuItem(teacherAssistant.getCourse().getLecturesList().get(i).getLectureTitle()));
            menuItemsLecturesNames.add(teacherAssistant.getCourse().getLecturesList().get(i).getLectureTitle());
            int finalI = i;
            menuItemsLectures.get(i).setOnAction(e -> handleMenuItem(menuItemsLecturesNames.get(finalI), menuAddAttendance));


        }
        menuAddAttendance.getItems().addAll(menuItemsLectures);


        if (!menuAddAttendance.getText().equals("Choose Lecture")) {
            handleMenuItem(menuAddAttendance.getText(), menuAddAttendance);
        }


    }

    public void onReports(ActionEvent actionEvent) {
    }

    public void onCreateNewStudent(ActionEvent event) {
        if (!textAddFirstName.getText().isEmpty()) {
            String id = "";
            if (radioMale.isSelected()) {
                id += 1;
            } else if (radioFemale.isSelected()) {
                id += 2;
            }
            id += LocalDate.now().getYear();
            id += teacherAssistant.getCourse().getStudentsList().size() + 1;
            Student student = new Student(id, textAddFirstName.getText(), textAddLastName.getText(), textAddEmail.getText(), textAddMajor.getText(), textAddAddress.getText(), Long.parseLong(textAddPhoneNumber.getText()));
            teacherAssistant.getCourse().addStudent(student);
            onRegisterStudent();
        }

    }

    public void onCreateNewLecture(ActionEvent event) {
        if (!textLectureTitle.getText().isEmpty()) {
            Lecture lecture = new Lecture(textLectureTitle.getText(), textLectureClassRome.getText(), Double.parseDouble(textDuration.getText()), (String) textLectureDate.getValue().toString());
            teacherAssistant.getCourse().addLecture(lecture);
            onAddLecture();
        }
    }

    public void fillStudentTable() {
        columnID.setCellValueFactory(new PropertyValueFactory<Student, String>("username"));
        columnFirstName.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        columnMajor.setCellValueFactory(new PropertyValueFactory<Student, String>("major"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));
        columnPhoneNumber.setCellValueFactory(new PropertyValueFactory<Student, Long>("phoneNumber"));


        ObservableList<Student> observableListStudent = FXCollections.observableArrayList(teacherAssistant.getCourse().getStudentsList());
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
        columnID.setCellFactory(TextFieldTableCell.forTableColumn());
        columnFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        columnLastName.setCellFactory(TextFieldTableCell.forTableColumn());
        columnEmail.setCellFactory(TextFieldTableCell.forTableColumn());
        columnMajor.setCellFactory(TextFieldTableCell.forTableColumn());
        columnAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        columnPhoneNumber.setCellFactory(TextFieldTableCell.forTableColumn(longConverter));

    }

    public void fillLectureTable() {

        columnLectureTitle.setCellValueFactory(new PropertyValueFactory<Lecture, String>("lectureTitle"));
        columnLectureClassRome.setCellValueFactory(new PropertyValueFactory<Lecture, String>("lectureClassRome"));
        columnDuration.setCellValueFactory(new PropertyValueFactory<Lecture, Double>("duration"));
        columnLectureDate.setCellValueFactory(new PropertyValueFactory<Lecture, String>("dateString"));

        ObservableList<Lecture> observableListLecture = FXCollections.observableArrayList(teacherAssistant.getCourse().getLecturesList());
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

    public void fillStudentReport(Student student) {

        List<LectureAttendance> lectureAttendances = new ArrayList<>();
        for (Lecture lecture : teacherAssistant.getCourse().getLecturesList()) {
            Attendance studentAttendance = null;
            boolean present = false;
            String dates = "";
            for (Attendance attendance : lecture.getAttendanceList()) {
                if (attendance.getStudent().equals(student)) {
                    studentAttendance = attendance;
                    present = true;
                    dates = studentAttendance.getTime().toString();
                    break;
                }
            }
            LectureAttendance lectureAttendance = new LectureAttendance(lecture.getLectureTitle(), lecture.getDateString());
            lectureAttendance.setAttendance(studentAttendance);
            lectureAttendance.setDate(dates);
            lectureAttendance.setPresent(present);
            lectureAttendances.add(lectureAttendance);
        }

        ObservableList<LectureAttendance> data = FXCollections.observableArrayList(lectureAttendances);
        tableStudentAttendance.setItems(data);

        columnStudentAttendanceLectureName.setCellValueFactory(new PropertyValueFactory<>("lectureName"));
        columnStudentAttendanceLectureDate.setCellValueFactory(new PropertyValueFactory<>("lectureDate"));
        columnStudentAttendanceStatus.setCellValueFactory(new PropertyValueFactory<>("present"));
        columnStudentAttendanceTime.setCellValueFactory(new PropertyValueFactory<>("date"));


        columnStudentAttendanceStatus.setCellFactory(column -> new CheckBoxTableCell<LectureAttendance, Boolean>() {
            @Override
            public void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    CheckBox checkBox = new CheckBox();
                    checkBox.setSelected(item != null && item);
                    checkBox.setOnAction(event -> {
                        LectureAttendance lectureAttendance = getTableRow().getItem();
                        Lecture lecture = teacherAssistant.getCourse().getLectureByName(lectureAttendance.getLectureName());
                        boolean newPresent = checkBox.isSelected();
                        if (!newPresent) {
                            lecture.removeAttendance(lectureAttendance.getAttendance());
                        } else if (newPresent) {
                            lecture.addAttendance(new Attendance(student, new Date()));
                        }
                    });
                    setGraphic(checkBox);
                }
            }
        });


    }

    public void onEditStudentID(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent) {
        Student student = tableStudent.getSelectionModel().getSelectedItem();
        student.setUsername(studentStringCellEditEvent.getNewValue());
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

    public void onEditStudentAddress(TableColumn.CellEditEvent<Student, String> studentStringCellEditEvent) {
        Student student = tableStudent.getSelectionModel().getSelectedItem();
        student.setAddress(studentStringCellEditEvent.getNewValue());
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

    public void showLecturesStatistics() {
        tableLecture.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                setAllNotVisible();
                page8.setVisible(true);

                String selectedItem = tableLecture.getSelectionModel().getSelectedItem().getLectureTitle();
                Lecture lecture = teacherAssistant.getCourse().getLectureByName(selectedItem);
                textLectureReportTitle.setText(selectedItem);
                textAttendancePercentage.setText(String.format("%%%.1f", teacherAssistant.getCourse().getLectureAttendancePercentage(lecture)));
                textAttendanceNumber.setText(String.format("%d", teacherAssistant.getCourse().getLectureAttendanceNumber(lecture)));
                fillLectureReport(lecture);
                tableLectureReport.refresh();


            }
        });
    }

    private void fillLectureReport(Lecture lecture) {

        List<LectureReport> lectureReports = new ArrayList<>();
        for (Student student : teacherAssistant.getCourse().getStudentsList()) {
            Attendance studentAttendance = null;
            boolean present = false;
            String dates = "";
            for (Attendance attendance : lecture.getAttendanceList()) {
                if (attendance.getStudent().equals(student)) {
                    studentAttendance = attendance;
                    present = true;
                    dates = studentAttendance.getTime().toString();
                    break;
                }
            }
            LectureReport lectureReport = new LectureReport(student.getUsername(), student.getFirstName() + " " + student.getLastName());
            lectureReport.setDate(dates);
            lectureReport.setPresent(present);
            lectureReports.add(lectureReport);
        }

        ObservableList<LectureReport> data = FXCollections.observableArrayList(lectureReports);
        tableLectureReport.setItems(data);

        columnLectureReportStudentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnLectureReportStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnLectureReportStatus.setCellValueFactory(new PropertyValueFactory<>("present"));
        columnLectureReportTime.setCellValueFactory(new PropertyValueFactory<>("date"));


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
                        teacherAssistant.getCourse().removeStudent(student);
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
                        teacherAssistant.getCourse().removeLecture(lecture);
                    }
                }
            }
        });
    }

    private void handleMenuItem(String menuItemText, MenuButton menuButton) {
        menuButton.setText(menuItemText);
        Lecture lecture = teacherAssistant.getCourse().getLectureByName(menuItemText);
        deleteRowsAttendance(lecture);
        showStudentReport(lecture);


        listViewAttendance.getItems().clear();
        for (int i = 0; i < lecture.getAttendanceList().size(); i++) {
            Student student = lecture.getAttendanceList().get(i).getStudent();
            listViewAttendance.getItems().add(student.getFirstName() + " " + student.getLastName());
        }
    }

    public void onImportXLS() {

        FileChooser fileChooser = new FileChooser();
        File file1 = fileChooser.showOpenDialog(null);

        if (file1 != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
                String line;
                while ((line = br.readLine()) != null) {
                    textEnterForAttendance.setText(line);
                    onSetAttendance();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void onDoneAttendance() {
        textEnterForAttendance.clear();
        menuAddAttendance.setText("Choose Lecture");
        listViewAttendance.getItems().clear();
        onRegisterAttendance();
    }

    public Student StudentSearch(String data) {
        for (int i = 0; i < teacherAssistant.getCourse().getStudentsList().size(); i++) {
            Student student = teacherAssistant.getCourse().getStudentsList().get(i);
            if (data.equals(student.getUsername()) ||
                    data.equals(student.getFirstName() + " " + student.getLastName()) ||
                    data.equals(String.valueOf(student.getPhoneNumber()))
            ) {
                return student;
            }
        }
        return null;

    }

    public void deleteRowsAttendance(Lecture lecture) {
        // في جزء الكود حيث تتم معالجة حدث الضغط على زر Delete
        listViewAttendance.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DELETE) {
                // الحصول على الصف المحدد في الـ TableView
                String selectedStudent = listViewAttendance.getSelectionModel().getSelectedItem();
                int index = listViewAttendance.getSelectionModel().getSelectedIndex();
                // التأكد من وجود صف محدد
                if (selectedStudent != null) {
                    // إنشاء مربع حوار التأكيد
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("تأكيد الحذف");
                    alert.setHeaderText(null);
                    alert.setContentText("هل أنت متأكد من رغبتك في حذف هذا الطالب؟");

                    // إضافة أزرار لمربع الحوار
                    ButtonType deleteButton = new ButtonType("حذف", ButtonBar.ButtonData.OK_DONE);
                    ButtonType cancelButton = new ButtonType("إلغاء", ButtonBar.ButtonData.CANCEL_CLOSE);
                    alert.getButtonTypes().setAll(deleteButton, cancelButton);

                    // عرض مربع الحوار وانتظار الاستجابة
                    Optional<ButtonType> result = alert.showAndWait();

                    // التحقق من الاستجابة
                    if (result.isPresent() && result.get() == deleteButton) {
                        // قم بتنفيذ عملية الحذف هنا
                        listViewAttendance.getItems().remove(selectedStudent);
                        lecture.getAttendanceList().remove(index);
                    }
                }
            }
        });
    }

    private void showStudentReport(Lecture lecture) {
        listViewAttendance.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                setAllNotVisible();
                page7.setVisible(true);
                String selectedItem = listViewAttendance.getSelectionModel().getSelectedItem();
                String username = teacherAssistant.getCourse().getStudentIdByFullName(selectedItem);
                Student student = teacherAssistant.getCourse().getStudentById(username);
                textStudentReportName.setText(selectedItem);
                textAttendancePercentage.setText(String.format("%%%.1f", teacherAssistant.getCourse().getStudentStatistics(student)));
                textAttendanceNumber.setText(String.format("%d", teacherAssistant.getCourse().getStudentAttendantLectures(student).size()));
                fillStudentReport(student);
                tableStudentAttendance.refresh();

            }
        });

    }

    public void onSetAttendance() {
        if (!menuAddAttendance.getText().equals("Choose Lecture")) {
            Student student = StudentSearch(textEnterForAttendance.getText());
            if (student != null) {
                Lecture lecture = teacherAssistant.getCourse().getLectureByName(menuAddAttendance.getText());
                if (!lecture.getAttendanceValue(student)) {
                    teacherAssistant.markAttendance(lecture, student);
                    listViewAttendance.getItems().add(student.getFirstName() + " " + student.getLastName());
                    labelStudent.setTextFill(GREEN);
                    labelStudent.setText(student.getUsername() + " added");
                    textEnterForAttendance.clear();
                } else {
                    labelStudent.setTextFill(RED);
                    labelStudent.setText("Already added");
                }


            } else {
                labelStudent.setTextFill(RED);
                labelStudent.setText("Can't find student*");
            }

        } else {
            labelStudent.setTextFill(RED);
            labelStudent.setText("Choose lecture*");
        }


    }

    public void onQrAttendance(ActionEvent event) {

        Webcam webcam = Webcam.getDefault();   //Generate Webcam Object
        webcam.setViewSize(new Dimension(320, 240));
        WebcamPanel webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setMirrored(false);
        JFrame jFrame = new JFrame();
        jFrame.add(webcamPanel);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);


        do {
            try {
                BufferedImage image = webcam.getImage();
                if (image != null) {
                    LuminanceSource source = new BufferedImageLuminanceSource(image);
                    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                    Result result = new MultiFormatReader().decode(bitmap);
                    if (result.getText() != null && !scannedCodes.contains(result.getText())) {

                        System.out.println(result.getText());
                        textEnterForAttendance.setText(result.getText());
                        onSetAttendance();
                        scannedCodes.add(result.getText());
                        jFrame.setVisible(false);
                        jFrame.dispose();
                        webcam.close();
                        break;

                    }
                }
            } catch (NotFoundException e) {
                //pass
            } catch (ReaderException e) {
                throw new RuntimeException(e);
            }
        } while (true);


    }

    public void onReportBad(ActionEvent event) {
        setAllNotVisible();
        page9.setVisible(true);
        tableStudentDelete.getItems().clear();
        tableStudent.refresh();
        fillDeleteTable();

    }

    private void fillDeleteTable() {
        ArrayList<Student> students = teacherAssistant.getCourse().getFailureStudents();

        columnID1.setCellValueFactory(new PropertyValueFactory<Student, String>("username"));
        columnFirstName1.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
        columnLastName1.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
        columnEmail1.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        columnMajor1.setCellValueFactory(new PropertyValueFactory<Student, String>("major"));
        columnAddress1.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));
        columnPhoneNumber1.setCellValueFactory(new PropertyValueFactory<Student, Long>("phoneNumber"));


        ObservableList<Student> observableListStudent = FXCollections.observableArrayList(students);
        tableStudentDelete.setItems(observableListStudent);

    }

    public void onExportBad(ActionEvent event) {
        fileChooserSave = new FileChooser();
        ArrayList<Student> students = teacherAssistant.getCourse().getFailureStudents();
        fileChooserSave.setTitle("Save");
        fileChooserSave.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv")
        );

        File selectedFile = fileChooserSave.showSaveDialog(null);
        if (selectedFile != null) {
            saveFile(selectedFile.getPath(), students);
        }
    }

    public void saveFile(String filePath, ArrayList<Student> students) {

        if (students != null) {
            if (!filePath.toLowerCase().endsWith(".csv")) {
                filePath += ".csv";
            }

            try (FileWriter writer = new FileWriter(filePath)) {
                // Write CSV header
                writer.append("Username,First Name,Last Name,Email,Major,Address,Phone Number\n");

                // Write student data
                for (Student student : students) {
                    writer.append(student.getUsername()).append(",");
                    writer.append(student.getFirstName()).append(",");
                    writer.append(student.getLastName()).append(",");
                    writer.append(student.getEmail()).append(",");
                    writer.append(student.getMajor()).append(",");
                    writer.append(student.getAddress()).append(",");
                    writer.append(student.getPhoneNumbers()).append("\n");
                }

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Noice");
                alert.setHeaderText("CSV file has been created successfully!");
                alert.setContentText(null);

                ButtonType yes = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);

                alert.getButtonTypes().setAll(yes);

                Optional<ButtonType> result = alert.showAndWait();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
