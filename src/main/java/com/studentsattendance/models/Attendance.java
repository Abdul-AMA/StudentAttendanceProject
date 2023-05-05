package com.studentsattendance.models;

import java.io.Serializable;
import java.util.Date;

public class Attendance implements Serializable {

//data fields
//----------------------------------------------------------------
    private Student student;
    private Date time;
//----------------------------------------------------------------
// Constructors
// ----------------------------------------------------------------
    public Attendance(Student student, Date date) {
        this.student = student;
        this.time = date;
    }
// ----------------------------------------------------------------
// getters and setters
// ----------------------------------------------------------------
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

// ----------------------------------------------------------------
// methods
// ----------------------------------------------------------------


}
