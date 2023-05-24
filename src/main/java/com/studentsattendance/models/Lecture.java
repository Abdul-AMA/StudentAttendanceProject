package com.studentsattendance.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.DatePicker;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Lecture implements Serializable {

//data fields
//----------------------------------------------------------------
    private String lectureTitle;
    private String lectureClassRome;
    private double duration;
    private Date lectureDate;
    private DatePicker datePicker;
    private LocalDate localDate;
    private String date;
    private ObjectProperty<DatePicker> datePickerProperty;
    private StringProperty dateStringProperty;


    private ArrayList<Attendance> attendanceList;
//----------------------------------------------------------------
// Constructors
// ----------------------------------------------------------------
    public Lecture() {
        this.attendanceList = new ArrayList<>();

    }
    public Lecture(DatePicker datePicker) {
        this.datePickerProperty = new SimpleObjectProperty<>(datePicker);
        this.attendanceList = new ArrayList<>();
    }
    public Lecture(String dateString) {
        this.dateStringProperty = new SimpleStringProperty(dateString);
        this.attendanceList = new ArrayList<>();
    }

    public Lecture(String lectureTitle, String lectureClassRome, double duration, Date lectureDate, ArrayList<Attendance> attendanceList) {
        this.lectureTitle = lectureTitle;
        this.lectureClassRome = lectureClassRome;
        this.duration = duration;
        this.lectureDate = lectureDate;
        this.attendanceList = attendanceList;

    }

    public Lecture(String lectureTitle, String lectureClassRome, double duration, Date lectureDate) {
        this.lectureTitle = lectureTitle;
        this.lectureClassRome = lectureClassRome;
        this.duration = duration;
        this.lectureDate = lectureDate;
        this.attendanceList = new ArrayList<>();
    }



    public Lecture(String lectureTitle, String lectureClassRome, double duration, DatePicker datePicker) {
        this.lectureTitle = lectureTitle;
        this.lectureClassRome = lectureClassRome;
        this.duration = duration;
        this.datePickerProperty = new SimpleObjectProperty<>(datePicker);
        this.attendanceList = new ArrayList<>();
    }



    public Lecture(String lectureTitle, String lectureClassRome, double duration, String dateString) {
        this.lectureTitle = lectureTitle;
        this.lectureClassRome = lectureClassRome;
        this.duration = duration;
        this.dateStringProperty = new SimpleStringProperty(dateString);
        this.attendanceList = new ArrayList<>();
    }

    // ----------------------------------------------------------------
// methods
// ----------------------------------------------------------------
    public void addAttendance(Attendance attendance) {
        attendanceList.add(attendance);
    }

    public void removeAttendance(Attendance attendance){
        attendanceList.remove(attendance);
    }

    public boolean getAttendanceValue(Student student) {
        for (int i = 0; i < attendanceList.size(); i++) {
            if (attendanceList.get(i).getStudent().equals(student)) {
                return true;

            }
        }
        return false;

    }
    public ObjectProperty<DatePicker> datePickerProperty() {
        return datePickerProperty;
    }

    public DatePicker getDatePicker() {
        return datePickerProperty.get();
    }

    public void setDatePicker(DatePicker datePicker) {
        datePickerProperty.set(datePicker);
    }
    public StringProperty dateStringProperty() {
        return dateStringProperty;
    }

    public String getDateString() {
        return dateStringProperty.get();
    }

    public void setDateString(String dateString) {
        dateStringProperty.set(dateString);
    }




// ----------------------------------------------------------------
// getters and setters
// ----------------------------------------------------------------

    public String getLectureTitle() {
        return lectureTitle;
    }

    public void setLectureTitle(String lectureTitle) {
        this.lectureTitle = lectureTitle;
    }

    public String getLectureClassRome() {
        return lectureClassRome;
    }

    public void setLectureClassRome(String lectureClassRome) {
        this.lectureClassRome = lectureClassRome;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Date getLectureDate() {
        return lectureDate;
    }

    public void setLectureDate(Date lectureDate) {
        this.lectureDate = lectureDate;
    }

    public ArrayList<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(ArrayList<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }


    @Override
    public String toString() {
        return "Lecture{" +
                "lectureTitle='" + lectureTitle + '\'' +
                ", lectureClassRome='" + lectureClassRome + '\'' +
                ", duration=" + duration +
                ", lectureDate=" + lectureDate +
                ", attendanceList=" + attendanceList +
                '}';
    }
    // ----------------------------------------------------------------

}
