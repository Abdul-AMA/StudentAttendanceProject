package com.studentsattendance.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class TeacherAssistant extends User implements Serializable {
//data fields
//----------------------------------------------------------------
    private Course course;
//----------------------------------------------------------------
// Constructors
// ----------------------------------------------------------------


    public TeacherAssistant(String username, String password, String firstName, String lastName, String email, Course course) {
        super(username, password, firstName, lastName, email);
        this.course = course;
    }

    public TeacherAssistant() {
    }

// ----------------------------------------------------------------
// getters and setters
// ----------------------------------------------------------------

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

// ----------------------------------------------------------------
// methods
// ----------------------------------------------------------------


    public void markAttendance(Lecture lecture, Student student) {
        lecture.addAttendance(new Attendance(student, new Date()));
    }






}
