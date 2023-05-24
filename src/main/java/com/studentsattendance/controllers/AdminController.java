package com.studentsattendance.controllers;

import com.studentsattendance.Navigation;
import com.studentsattendance.models.Administrator;
import com.studentsattendance.models.Course;
import com.studentsattendance.models.DataModel;
import com.studentsattendance.models.TeacherAssistant;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public StackPane stackPane;
    public TableColumn<Course, String> columnCourseId;
    public TableColumn<Course,String> columnCourseName;
    public TableColumn<Course,String> columnCourseDoctor;
    public TableColumn<Course,Integer> columnCourseHours;
    public TableColumn<Course,String> columnCourseBook;
    public TableColumn<Course,String> columnCourseDescription;
    public TableColumn<Course,Integer> columnCourseMaximumAbsence;
    public MenuButton menuButtonTA;
    public MenuButton menuButtonAddCourse;
    public MenuButton menuButtonEditTACourse;
    @FXML
    private TableColumn<TeacherAssistant, String> columnCourseNameTA;

    @FXML
    private TableColumn<TeacherAssistant, String> columnEmailTA;

    @FXML
    private TableColumn<TeacherAssistant, String> columnFirstNameTA;

    @FXML
    private TableColumn<TeacherAssistant, String> columnLastNameTA;

    @FXML
    private TableColumn<TeacherAssistant, String> columnPassTA;

    @FXML
    private TableColumn<TeacherAssistant, String> columnUserNameTA;

    public TableView<Course> tableCourses;
    public TableView<TeacherAssistant> tableTA;
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
    private TextField textEmailTA;

    @FXML
    private TextField textFirstNameTA;

    @FXML
    private TextField textLastNameTA;

    @FXML
    private TextField textPassTA;

    @FXML
    private TextField textUserNameTA;

    @FXML
    private TextField textEmailTAedit;
    @FXML
    private TextField textFirstNameTAedit;
    @FXML
    private TextField textLastNameTAedit;
    @FXML
    private TextField textPassTAedit;
    @FXML
    private TextField textUserNameTAedit;


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

    ArrayList<MenuItem> menuItemsCourse1 = new ArrayList<MenuItem>();
    ArrayList<String> menuItemsCourseNames1 = new ArrayList<String>();

    ArrayList<MenuItem> menuItemsCourse2 = new ArrayList<MenuItem>();
    ArrayList<String> menuItemsCourseNames2 = new ArrayList<String>();

    ArrayList<MenuItem> menuItemsCourse3 = new ArrayList<MenuItem>();
    ArrayList<String> menuItemsCourseNames3 = new ArrayList<String>();
    ArrayList<MenuItem> menuItemsTA1 = new ArrayList<MenuItem>();
    ArrayList<String> menuItemsNamesTA1 = new ArrayList<String>();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataModel = new DataModel();
        administrator = dataModel.getAdministrator();
       // deleteRowsCourse();
        hover();


    }



    public void setAllNotVisible() {
        page1.setVisible(false);
        page2.setVisible(false);
//        page3.setVisible(false);
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
        deleteRowsCourse();
        tableCourses.refresh();



    }
//    public void onEditCourse() {
//        setAllNotVisible();
//        page3.setVisible(true);
//
//        menuButtonEditCourse.getItems().clear();
//        menuItemsCourse1.clear();
//        menuItemsCourseNames1.clear();
//        menuButtonEditCourse.setText("Courses");
//        for (int i = 0; i < administrator.getCourseList().size(); i++) {
//            menuItemsCourse1.add(new MenuItem(administrator.getCourseList().get(i).getCourseName()));
//            menuItemsCourseNames1.add(administrator.getCourseList().get(i).getCourseName());
//            int finalI = i;
//            menuItemsCourse1.get(i).setOnAction(e -> handleMenuItem(menuItemsCourseNames1.get(finalI) , menuButtonEditCourse));
//
//
//        }
//        menuButtonEditCourse.getItems().addAll(menuItemsCourse1);
//
//        textEditCourseId.clear();
//        textEditCourseName.clear();
//        textEditCourseDoctor.clear();
//        textEditCourseBook.clear();
//        textEditCourseDescription.clear();
//        textEditCourseHour.clear();
//
//
//
//
//    }



    public void onCreateTeacher() {
        setAllNotVisible();
        page4.setVisible(true);


        menuButtonAddCourse.getItems().clear();
        menuItemsCourse2.clear();
        menuItemsCourseNames2.clear();
        menuButtonAddCourse.setText("Courses");
        for (int i = 0; i < administrator.getCourseList().size(); i++) {
            menuItemsCourse2.add(new MenuItem(administrator.getCourseList().get(i).getCourseName()));
            menuItemsCourseNames2.add(administrator.getCourseList().get(i).getCourseName());
            int finalI = i;
            menuItemsCourse2.get(i).setOnAction(e -> handleMenuItem(menuItemsCourseNames2.get(finalI) , menuButtonAddCourse));
        }
        menuButtonAddCourse.getItems().addAll(menuItemsCourse2);


        textUserNameTA.clear();
        textPassTA.clear();
        textFirstNameTA.clear();
        textLastNameTA.clear();
        textEmailTA.clear();



    }
    public void onShowTA(ActionEvent event) {
        setAllNotVisible();
        page5.setVisible(true);
        fillTeacherTable();
        tableTA.refresh();
        deleteRowsAccountTa();
        tableTA.refresh();

    }

    public void onEditTeacher( ) {
        setAllNotVisible();
        page6.setVisible(true);

        menuButtonTA.getItems().clear();
        menuItemsTA1.clear();
        menuItemsNamesTA1.clear();
        menuButtonTA.setText("Teachers");
        for (int i = 0; i < administrator.getTeacherAssistantList().size(); i++) {
            menuItemsTA1.add(new MenuItem(administrator.getTeacherAssistantList().get(i).getUsername()));
            menuItemsNamesTA1.add(administrator.getTeacherAssistantList().get(i).getUsername());
            int finalI = i;
            menuItemsTA1.get(i).setOnAction(e -> handleMenuItem    (menuItemsNamesTA1.get(finalI) , menuButtonTA));

        }
        menuButtonTA.getItems().addAll(menuItemsTA1);

        menuButtonEditTACourse.getItems().clear();
        menuItemsCourse3.clear();
        menuItemsCourseNames3.clear();
        menuButtonEditTACourse.setText("Courses");
        for (int i = 0; i < administrator.getCourseList().size(); i++) {
            menuItemsCourse3.add(new MenuItem(administrator.getCourseList().get(i).getCourseName()));
            menuItemsCourseNames3.add(administrator.getCourseList().get(i).getCourseName());
            int finalI = i;
            menuItemsCourse3.get(i).setOnAction(e -> handleMenuItem(menuItemsCourseNames3.get(finalI) , menuButtonEditTACourse));
        }
        menuButtonEditTACourse.getItems().addAll(menuItemsCourse3);
//
//
//        textUserNameTAedit.clear();
//        textPassTAedit.clear();
//        textFirstNameTAedit.clear();
//        textLastNameTAedit.clear();
//        textEmailTAedit.clear();

    }
    public void onLogOut(ActionEvent event) {
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
            navigation.navigateTo(stackPane,Navigation.Login_FXML);
        } else if (result.get() == do_not_save) {
            navigation.navigateTo(stackPane,Navigation.Login_FXML);
        }
    }

    public void onCreateNewCourse(ActionEvent event) {
        Course course = new Course(textCourseId.getText(),textCourseName.getText(),textCourseDoctor.getText(),Integer.parseInt(textCourseHour.getText()),
                textCourseBook.getText(),textCourseDescription.getText());
        administrator.addCourse(course);
        onCreateCourse();
    }


//    public void onButtonEditCourse(ActionEvent event) {
//        if (!menuButtonEditCourse.getText().equals("Courses")){
//            int index = administrator.getCourseIndexByName(menuButtonEditCourse.getText());
//            Course course = administrator.getCourseList().get(index);
//            if (!textEditCourseId.getText().isEmpty()){
//                course.setCourseId(textEditCourseId.getText());
//            }
//            if (!textEditCourseName.getText().isEmpty()){
//                course.setCourseName(textEditCourseName.getText());
//            }
//            if (!textEditCourseDoctor.getText().isEmpty()){
//                course.setDoctor(textEditCourseDoctor.getText());
//            }
//            if (!textEditCourseBook.getText().isEmpty()){
//                course.setBook(textEditCourseBook.getText());
//            }
//            if (!textEditCourseDescription.getText().isEmpty()){
//                course.setDescription(textEditCourseDescription.getText());
//            }
//            if (!textEditCourseHour.getText().isEmpty()){
//                course.setCourseHours(Integer.parseInt(textEditCourseHour.getText()));
//            }
//            onEditCourse();
//
//        }
//    }

//    public void onButtonDeleteCourse(ActionEvent event) {
//        if (!menuButtonEditCourse.getText().equals("Courses")){
//            int index = administrator.getCourseIndexByName(menuButtonEditCourse.getText());
//            administrator.getCourseList().remove(administrator.getCourseList().get(index));
//        }
//        onEditCourse();
//
//    }

    private void handleMenuItem(String menuItemText, MenuButton menuButton) {
        menuButton.setText(menuItemText);
    }



    public void fillCoursesTable(){
        columnCourseId.setCellValueFactory(new PropertyValueFactory<Course,String>("courseId"));
        columnCourseName.setCellValueFactory(new PropertyValueFactory<Course,String>("courseName"));
        columnCourseDoctor.setCellValueFactory(new PropertyValueFactory<Course,String>("courseDoctor"));
        columnCourseHours.setCellValueFactory(new PropertyValueFactory<Course,Integer>("courseHours"));
        columnCourseBook.setCellValueFactory(new PropertyValueFactory<Course,String>("book"));
        columnCourseDescription.setCellValueFactory(new PropertyValueFactory<Course,String>("description"));
        columnCourseMaximumAbsence.setCellValueFactory(new PropertyValueFactory<Course,Integer>("maximumAbsence"));
        ObservableList<Course> observableListCourses = FXCollections.observableArrayList(administrator.getCourseList());
        tableCourses.setItems(observableListCourses);

        //------------------
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

//---------------------------
        //for edit table
        tableCourses.setEditable(true);
        columnCourseId.setCellFactory(TextFieldTableCell.forTableColumn());
        columnCourseName.setCellFactory(TextFieldTableCell.forTableColumn());
        columnCourseDoctor.setCellFactory(TextFieldTableCell.forTableColumn());
        columnCourseHours.setCellFactory(TextFieldTableCell.forTableColumn(integerConverter));
        columnCourseBook.setCellFactory(TextFieldTableCell.forTableColumn());
        columnCourseDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        columnCourseMaximumAbsence.setCellFactory(TextFieldTableCell.forTableColumn(integerConverter));


    }


    public void onCreateNewAccount(ActionEvent event){

        if (!menuButtonAddCourse.getText().equals("Courses")) {
            int index = administrator.getCourseIndexByName(menuButtonAddCourse.getText());
            Course course = administrator.getCourseList().get(index);
            TeacherAssistant ta = new TeacherAssistant(textUserNameTA.getText(), textPassTA.getText(), textFirstNameTA.getText(), textLastNameTA.getText(),
                    textEmailTA.getText(), course);
            administrator.addTeacher(ta);


            onCreateTeacher();
        }
    }

    public void fillTeacherTable(){
        columnUserNameTA.setCellValueFactory(new PropertyValueFactory<TeacherAssistant,String>("username"));
        columnPassTA.setCellValueFactory(new PropertyValueFactory<TeacherAssistant,String>("password"));
        columnFirstNameTA.setCellValueFactory(new PropertyValueFactory<TeacherAssistant,String>("firstName"));
        columnLastNameTA.setCellValueFactory(new PropertyValueFactory<TeacherAssistant,String>("lastName"));
        columnEmailTA.setCellValueFactory(new PropertyValueFactory<TeacherAssistant,String>("email"));
        columnCourseNameTA.setCellValueFactory(new PropertyValueFactory<TeacherAssistant,String>("courseName"));

        ObservableList<TeacherAssistant> observableListCourses = FXCollections.observableArrayList(administrator.getTeacherAssistantList());
        tableTA.setItems(observableListCourses);
        tableTA.setEditable(true);
        columnUserNameTA.setCellFactory(TextFieldTableCell.forTableColumn());
        columnPassTA.setCellFactory(TextFieldTableCell.forTableColumn());
        columnFirstNameTA.setCellFactory(TextFieldTableCell.forTableColumn());
        columnLastNameTA.setCellFactory(TextFieldTableCell.forTableColumn());
        columnEmailTA.setCellFactory(TextFieldTableCell.forTableColumn());
        columnCourseNameTA.setCellFactory(TextFieldTableCell.forTableColumn());
    }


    public void onEditTA(ActionEvent event) {

        if (!menuButtonTA.getText().equals("Teachers")){
            int index = administrator.getTeacherIndexByName(menuButtonTA.getText());
            TeacherAssistant teacherAssistant = administrator.getTeacherAssistantList().get(index);
//
//            if (!textUserNameTAedit.getText().isEmpty()){
//                teacherAssistant.setUsername(textUserNameTAedit.getText());
//            }
//            if (!textPassTAedit.getText().isEmpty()){
//                teacherAssistant.setPassword(textPassTAedit.getText());
//            }
//            if (!textFirstNameTAedit.getText().isEmpty()){
//                teacherAssistant.setFirstName(textFirstNameTAedit.getText());
//            }
//            if (!textLastNameTAedit.getText().isEmpty()){
//                teacherAssistant.setLastName(textLastNameTAedit.getText());
//            }
//            if (!textEmailTAedit.getText().isEmpty()){
//                teacherAssistant.setEmail(textEmailTAedit.getText());
//            }
            if (!menuButtonEditTACourse.getText().equals("Courses")) {
                int indexCourse = administrator.getCourseIndexByName(menuButtonEditTACourse.getText());
                Course course = administrator.getCourseList().get(indexCourse);
                System.out.println(course.getCourseName());
                teacherAssistant.setCourse(course);
                System.out.println(teacherAssistant.getCourse().getCourseName());

            }

            onEditTeacher();


        }
    }

//    public void onDeleteTA(ActionEvent event) {
//        if (!menuButtonTA.getText().equals("Teachers")){
//            int index = administrator.getTeacherIndexByName(menuButtonTA.getText());
//            administrator.getTeacherAssistantList().remove(administrator.getTeacherAssistantList().get(index));
//        }
//        onEditTeacher();
//
//    }

//----------------------------------------------------------------------------------
    //for course table
    public void onEditCourseName(TableColumn.CellEditEvent<Course, String> courseStringCellEditEvent) {
        Course course = tableCourses.getSelectionModel().getSelectedItem();
        course.setCourseName(courseStringCellEditEvent.getNewValue());
    }

    public void onEditCourseId(TableColumn.CellEditEvent<Course, String> courseStringCellEditEvent) {
        Course course = tableCourses.getSelectionModel().getSelectedItem();
        course.setCourseId(courseStringCellEditEvent.getNewValue());
    }

    public void onEditCourseDoctor(TableColumn.CellEditEvent<Course, String> courseStringCellEditEvent) {
        Course course = tableCourses.getSelectionModel().getSelectedItem();
        course.setDoctor(courseStringCellEditEvent.getNewValue());
    }

    public void onEditCourseHours(TableColumn.CellEditEvent<Course, Integer> courseIntegerCellEditEvent) {
        Course course = tableCourses.getSelectionModel().getSelectedItem();
        course.setCourseHours(courseIntegerCellEditEvent.getNewValue());
    }

    public void onEditCourseBook(TableColumn.CellEditEvent<Course, String> courseStringCellEditEvent) {
        Course course = tableCourses.getSelectionModel().getSelectedItem();
        course.setBook(courseStringCellEditEvent.getNewValue());
    }

    public void onEditCourseDescription(TableColumn.CellEditEvent<Course, String> courseStringCellEditEvent) {
        Course course = tableCourses.getSelectionModel().getSelectedItem();
        course.setDescription(courseStringCellEditEvent.getNewValue());
    }

    public void onEditCourseMaxAbs(TableColumn.CellEditEvent<Course, Integer> courseIntegerCellEditEvent) {
        Course course = tableCourses.getSelectionModel().getSelectedItem();
        course.setMaximumAbsence(courseIntegerCellEditEvent.getNewValue());
    }

//----------------------------------------------------------------------------------
    //for teacher table

    public void onEditTeacherUser(TableColumn.CellEditEvent<TeacherAssistant, String> teacherAssistantStringCellEditEvent) {
        TeacherAssistant teacherAssistant = tableTA.getSelectionModel().getSelectedItem();
        teacherAssistant.setUsername(teacherAssistantStringCellEditEvent.getNewValue());
    }

    public void onEditTeacherPass(TableColumn.CellEditEvent<TeacherAssistant, String> teacherAssistantStringCellEditEvent) {
        TeacherAssistant teacherAssistant = tableTA.getSelectionModel().getSelectedItem();
        teacherAssistant.setPassword(teacherAssistantStringCellEditEvent.getNewValue());
    }

    public void onEditTeacherFirstName(TableColumn.CellEditEvent<TeacherAssistant, String> teacherAssistantStringCellEditEvent) {
        TeacherAssistant teacherAssistant = tableTA.getSelectionModel().getSelectedItem();
        teacherAssistant.setFirstName(teacherAssistantStringCellEditEvent.getNewValue());
    }

    public void onEditTeacherLastName(TableColumn.CellEditEvent<TeacherAssistant, String> teacherAssistantStringCellEditEvent) {
        TeacherAssistant teacherAssistant = tableTA.getSelectionModel().getSelectedItem();
        teacherAssistant.setLastName(teacherAssistantStringCellEditEvent.getNewValue());
    }

    public void onEditTeacherEmail(TableColumn.CellEditEvent<TeacherAssistant, String> teacherAssistantStringCellEditEvent) {
        TeacherAssistant teacherAssistant = tableTA.getSelectionModel().getSelectedItem();
        teacherAssistant.setEmail(teacherAssistantStringCellEditEvent.getNewValue());
    }

    public void onEditTeacherCourseName(TableColumn.CellEditEvent<TeacherAssistant, String> teacherAssistantStringCellEditEvent) {
        TeacherAssistant teacherAssistant = tableTA.getSelectionModel().getSelectedItem();
        teacherAssistant.setCourseName(teacherAssistantStringCellEditEvent.getNewValue());
    }
    public void deleteRowsCourse() {
        // في جزء الكود حيث تتم معالجة حدث الضغط على زر Delete
        tableCourses.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DELETE) {
                // الحصول على الصف المحدد في الـ TableView
                Course selectedCourse = tableCourses.getSelectionModel().getSelectedItem();

                // التأكد من وجود صف محدد
                if (selectedCourse != null) {
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
                        tableCourses.getItems().remove(selectedCourse);
                        administrator.removeCourse(selectedCourse);
                    }
                }
            }
        });
    }
    public void deleteRowsAccountTa() {
        // في جزء الكود حيث تتم معالجة حدث الضغط على زر Delete
        tableTA.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DELETE) {
                // الحصول على الصف المحدد في الـ TableView
                TeacherAssistant teacherAssistant = tableTA.getSelectionModel().getSelectedItem();

                // التأكد من وجود صف محدد
                if (teacherAssistant != null) {
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
                        tableTA.getItems().remove(teacherAssistant);
                        administrator.removeTeacher(teacherAssistant);
                    }
                }
            }
        });
    }

}
