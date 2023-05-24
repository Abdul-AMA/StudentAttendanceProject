package com.studentsattendance.models;

import java.io.Serializable;

public class Student implements Serializable {

//data fields
//----------------------------------------------------------------
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private boolean status;

    private long phoneNumber;


    public Student(String firstName, String lastName, String email, String major, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.phoneNumber = phoneNumber;
    }

    //----------------------------------------------------------------
// Constructors
// ----------------------------------------------------------------
    public Student(String username, String password, String firstName, String lastName, String email, String major, long phoneNumber) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        status = true;
        this.phoneNumber = phoneNumber;
    }

    public Student() {
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", status=" + status +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

// ----------------------------------------------------------------
// methods
// ----------------------------------------------------------------


}
