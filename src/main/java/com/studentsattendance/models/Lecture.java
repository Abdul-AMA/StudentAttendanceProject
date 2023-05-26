package com.studentsattendance.models;

import javafx.beans.property.ObjectProperty;
import javafx.scene.control.DatePicker;
import java.io.Serializable;
import java.util.ArrayList;

public class Lecture implements Serializable {

//data fields
//----------------------------------------------------------------
    private String lectureTitle;
    private String lectureClassRome;
    private double duration;
    private String  dateString;


    private ArrayList<Attendance> attendanceList;
//----------------------------------------------------------------
// Constructors
// ----------------------------------------------------------------
    public Lecture() {
        this.attendanceList = new ArrayList<>();

    }

    public Lecture(String lectureTitle, String lectureClassRome, double duration,String dateString,  ArrayList<Attendance> attendanceList) {
        this.lectureTitle = lectureTitle;
        this.lectureClassRome = lectureClassRome;
        this.duration = duration;
        this.dateString = dateString;
        this.attendanceList = attendanceList;

    }

    public Lecture(String lectureTitle, String lectureClassRome, double duration, String dateString) {
        this.lectureTitle = lectureTitle;
        this.lectureClassRome = lectureClassRome;
        this.duration = duration;
        this.dateString = dateString;
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

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
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
                ", lectureDate=" + dateString +
                ", attendanceList=" + attendanceList +
                '}';
    }
    // ----------------------------------------------------------------

}
