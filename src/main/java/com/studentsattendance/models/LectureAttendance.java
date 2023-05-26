package com.studentsattendance.models;

import java.util.Date;

public class LectureAttendance {
    private String lectureName;
    private String lectureDate;
    private String date;
    private boolean present;
    private Attendance attendance;

    // Constructor, getters, and setters


    public LectureAttendance(String lectureName, String lectureDate ) {
        this.lectureName = lectureName;
        this.lectureDate = lectureDate;
    }

    public LectureAttendance() {
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public String getLectureDate() {
        return lectureDate;
    }

    public void setLectureDate(String lectureDate) {
        this.lectureDate = lectureDate;
    }
}
