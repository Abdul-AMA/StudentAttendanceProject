package com.studentsattendance.models;

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

    private ArrayList<Attendance> attendanceList;
//----------------------------------------------------------------
// Constructors
// ----------------------------------------------------------------
    public Lecture() {
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
        this.attendanceList = new ArrayList<Attendance>();
    }

    public Lecture(String lectureTitle, String lectureClassRome, double duration) {
        this.lectureTitle = lectureTitle;
        this.lectureClassRome = lectureClassRome;
        this.duration = duration;
    }

    public Lecture(String lectureTitle, String lectureClassRome, double duration, DatePicker datePicker) {
        this.lectureTitle = lectureTitle;
        this.lectureClassRome = lectureClassRome;
        this.duration = duration;
        this.datePicker = datePicker;
    }

    public Lecture(String lectureTitle, String lectureClassRome, double duration, LocalDate localDate) {
        this.lectureTitle = lectureTitle;
        this.lectureClassRome = lectureClassRome;
        this.duration = duration;
        this.localDate = localDate;
    }

    public Lecture(String lectureTitle, String lectureClassRome, double duration, String date) {
        this.lectureTitle = lectureTitle;
        this.lectureClassRome = lectureClassRome;
        this.duration = duration;
        this.date = date;
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

    public void setDuration(int duration) {
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
