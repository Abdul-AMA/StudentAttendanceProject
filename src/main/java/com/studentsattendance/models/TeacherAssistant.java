package com.studentsattendance.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class TeacherAssistant implements Serializable {
//data fields
//----------------------------------------------------------------
    private Course course;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
//----------------------------------------------------------------
// Constructors
// ----------------------------------------------------------------


    public TeacherAssistant(String username, String password, String firstName, String lastName, String email, Course course) {
        this.course = course;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public TeacherAssistant() {
    }

// ----------------------------------------------------------------
// getters and setters
// ----------------------------------------------------------------

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "TeacherAssistant{" +
                "course=" + course +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


// ----------------------------------------------------------------
// methods
// ----------------------------------------------------------------


    public void markAttendance(Lecture lecture, Student student) {
        lecture.addAttendance(new Attendance(student, new Date()));
    }






}
