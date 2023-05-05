package com.studentsattendance.models;

import java.io.Serializable;

public class Student extends User implements Serializable {

//data fields
//----------------------------------------------------------------
    private String major;
    private boolean status;

    private int phoneNumber;


//----------------------------------------------------------------
// Constructors
// ----------------------------------------------------------------
    public Student(String username, String password, String firstName, String lastName, String email, String major, int phoneNumber) {
        super(username, password, firstName, lastName, email);
        this.major = major;
        status = true;
        this.phoneNumber = phoneNumber;
    }

    public Student() {
    }

    // ----------------------------------------------------------------
// getters and setters
// ----------------------------------------------------------------

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "major='" + major + '\'' +
                ", status=" + status +
                '}';
    }


// ----------------------------------------------------------------
// methods
// ----------------------------------------------------------------


}
