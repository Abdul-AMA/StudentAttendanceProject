module com.studentsattendance {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.studentsattendance.models to javafx.base;

    opens com.studentsattendance to javafx.fxml;
    exports com.studentsattendance;
    exports com.studentsattendance.controllers;
    opens com.studentsattendance.controllers to javafx.fxml;
}