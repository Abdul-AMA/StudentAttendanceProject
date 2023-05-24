package com.studentsattendance.models;



import java.io.Serializable;
import java.util.ArrayList;

public class Administrator  implements Serializable {

//data fields
//----------------------------------------------------------------
    private String username;
    private String password;
    private String email;

    private ArrayList<Course> courseList;
    private ArrayList<TeacherAssistant> teacherAssistantList;

   // private ArrayList<Student> StudentList;  //new

//----------------------------------------------------------------
// Constructors
// ----------------------------------------------------------------
    public Administrator(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.courseList = new ArrayList<>();
        this.teacherAssistantList = new ArrayList<>();
       // this.StudentList = new ArrayList<>();
    }

    public Administrator() {
        this.courseList = new ArrayList<>();
        this.teacherAssistantList = new ArrayList<>();
      //  this.StudentList = new ArrayList<>();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public ArrayList<TeacherAssistant> getTeacherAssistantList() {
        return teacherAssistantList;
    }

    public void setTeacherAssistantList(ArrayList<TeacherAssistant> teacherAssistantList) {
        this.teacherAssistantList = teacherAssistantList;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", courseList=" + courseList +
                ", teacherAssistantList=" + teacherAssistantList +
                '}';
    }

    // ----------------------------------------------------------------
// methods
// ----------------------------------------------------------------
    public void addCourse(Course course) {

        this.courseList.add(course);
    }

    public void removeCourse(Course course) {

        this.courseList.remove(course);
    }

    public void addTeacher(TeacherAssistant teacherAssistant) {

        this.teacherAssistantList.add(teacherAssistant);
    }

    public void removeTeacher(TeacherAssistant teacherAssistant) {

        this.teacherAssistantList.remove(teacherAssistant);
    }

//    public ArrayList<Student> getStudentList() {
//        return StudentList;
//    }
//
//    public void addStudent(Student student){
//        this.StudentList.add(student);
//    }
//    public void removeStudent(Student student){
//        this.StudentList.remove(student);
//    }

    public void linkCourseTeacher(TeacherAssistant teacherAssistant , Course course) {
        teacherAssistant.setCourse(course);
    }

    public TeacherAssistant getTeacherAssistantByUsername(String username) {
        for (int i = 0; i < teacherAssistantList.size() ; i++) {
            if (teacherAssistantList.get(i).getUsername().equals(username)) {
                return teacherAssistantList.get(i);
            }
        }
        return null;
    }


    public int getCourseIndexByName(String courseName) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseName().equals(courseName)){
                return i;
            }
        }
        return -1;
    }

    public int getTeacherIndexByName(String TeacherUserName) {
        for (int i = 0; i < teacherAssistantList.size(); i++) {
            if (teacherAssistantList.get(i).getUsername().equals(TeacherUserName)){
                return i;
            }
        }
        return -1;
    }






}
