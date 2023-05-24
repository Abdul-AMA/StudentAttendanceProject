package com.studentsattendance.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Course implements Serializable {

//data fields
//----------------------------------------------------------------
    private String courseId;
    private String courseName;
    private String courseDoctor;

    private int courseHours;
    private String book;
    private String description;
    private int maximumAbsence;
    private ArrayList<Student> studentsList;
    private ArrayList<Lecture> lecturesList;
//----------------------------------------------------------------
// Constructors
// ----------------------------------------------------------------
    public Course() {
        this.studentsList = new ArrayList<>();
        this.lecturesList = new ArrayList<>();
    }

    public Course(String courseId, String courseName,String courseDoctor, int courseHours, String book, String description) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDoctor = courseDoctor;
        this.courseHours = courseHours;
        this.book = book;
        this.description = description;
        this.studentsList = new ArrayList<>();
        this.lecturesList = new ArrayList<>();
        //اكبر عدد محاضرات يمكن غيابه
        maximumAbsence = (int) Math.ceil(15*courseHours*.25);
    }
// ----------------------------------------------------------------
// methods
// ----------------------------------------------------------------
    public void addStudent(Student student) {
        studentsList.add(student);
    }
    public void removeStudent(Student student) {
        studentsList.remove(student);
    }
    public void addLecture(Lecture lecture) {
        lecturesList.add(lecture);
    }

    //عرض تقرير الحضور لكل طالب في مساق معين بسرعة عند طلب الطالب
    // عرض نسبة حضور الطالب بالمحاضرات
    public double getStudentStatistics(Student student) {
        int attendance = 0;
        int allLectures = lecturesList.size();
        for (int i = 0; i < lecturesList.size(); i++) {
            if (lecturesList.get(i).getAttendanceValue(student)) {
                attendance++;
            }
        }

        return 100*(double) attendance/(double) allLectures;
    }
    // عرض المحاضرات التي حضرها الطالب
    public ArrayList<Lecture> getStudentAttendantLectures(Student student) {
        ArrayList<Lecture> attendantLectures = new ArrayList<Lecture>();
        for (int i = 0; i < lecturesList.size(); i++) {
            if (lecturesList.get(i).getAttendanceValue(student)){
                attendantLectures.add(lecturesList.get(i));
            }
        }

        return attendantLectures;
    }
    // عرض المحاضرات التي لم  يحضرها الطالب
    public ArrayList<Lecture> getStudentAbsenceLectures(Student student) {
        ArrayList<Lecture> absenceLectures = new ArrayList<Lecture>();
        for (int i = 0; i < lecturesList.size(); i++) {
            if (!lecturesList.get(i).getAttendanceValue(student)){
                absenceLectures.add(lecturesList.get(i));
            }
        }

        return absenceLectures;
    }


    //البحث عن كشف محاضرة معينة باستخدام عنوان المحاضرة.

    public ArrayList<Attendance>    getAttendancesByTitle(String lectureTitle){
        for (int i = 0; i < lecturesList.size(); i++) {
            if (lecturesList.get(i).getLectureTitle().equals(lectureTitle)){
                return lecturesList.get(i).getAttendanceList();
            }
        }
        return null;
    }
    //استخراج كشف بجميع الطلبة غير الملتزمين بحضور أكثر من 25% من المحاضرات في مساق معين
    //todo this
    public ArrayList<Student> getFailureStudents(){
        ArrayList<Student> failureStudents = new ArrayList<Student>();
        for (int i = 0; i < studentsList.size(); i++) {
            if (getStudentAbsenceLectures(studentsList.get(i)).size() > maximumAbsence){
                    failureStudents.add(studentsList.get(i));
                    studentsList.get(i).setStatus(false);
            }
        }

        return failureStudents;
    }
    //عرض كشوف الحضور والغياب لكل محاضرة من المحاضرات مع نسبة الحضور وعدد الحضور في كل محاضرة.
    public String getAttendanceAndAbsenceStatements(Lecture lecture) {


        return "Statement{" +"\n"+
                "Attendance Percentage=" + getLectureAttendancePercentage(lecture) + "\n"+
                "Attendance Number=" + getLectureAttendanceNumber(lecture) + "\n"+
                "Attendance Students=" + getLectureAttendantStudents(lecture) + "\n"+
                "Absence Students=" + getLectureAbsenceStudents(lecture) +"\n"+
                '}';
    }
    //نسبة الحضور  في كل محاضرة.
    public double getLectureAttendancePercentage(Lecture lecture){

        int allStudents = studentsList.size();

        return 100*(double) getLectureAttendanceNumber(lecture)/(double) allStudents;

    }
    //عدد الحضور  في كل محاضرة.
    public int getLectureAttendanceNumber(Lecture lecture){
        int attendances  = 0;
        for (int i = 0; i < studentsList.size(); i++) {
            if(lecture.getAttendanceValue(studentsList.get(i))){
                attendances++;
            }
        }
        return attendances;
    }
    // الحضور  في كل محاضرة.

    public ArrayList<Student> getLectureAttendantStudents(Lecture lecture){
            ArrayList<Student> attendantStudents = new ArrayList<Student>();
        for (int i = 0; i < studentsList.size(); i++) {
            if (lecture.getAttendanceValue(studentsList.get(i))){
                attendantStudents.add(studentsList.get(i));
            }
        }

        return attendantStudents;
    }

    // الغياب  في كل محاضرة.

    public ArrayList<Student> getLectureAbsenceStudents(Lecture lecture){
        ArrayList<Student> absenceStudents = new ArrayList<Student>();
        for (int i = 0; i < studentsList.size(); i++) {
            if (!lecture.getAttendanceValue(studentsList.get(i))){
                absenceStudents.add(studentsList.get(i));
            }
        }

        return absenceStudents;
    }


    // ارجاع object للطالب من خلال  رقم username

    public Student getStudentById(String usename){
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getUsername().equals(usename)){
                return studentsList.get(i);
            }
        }
        return null;
    }

    // ارجاع object للطالب من خلال  رقم جواله

    public Student getStudentByPhoneNumber(int phoneNumber){
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getPhoneNumber() == phoneNumber){
                return studentsList.get(i);
            }
        }
        return null;
    }

    // ارجاع object للطالب من خلال اسمه

    public Student getStudentByName(String firstName, String lastName){
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getFirstName().equals(firstName) && studentsList.get(i).getLastName().equals(lastName)){
                return studentsList.get(i);
            }
        }
        return null;
    }



// ----------------------------------------------------------------
// getters and setters
// ----------------------------------------------------------------

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(int courseHours) {
        this.courseHours = courseHours;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    //عرض جميع المحاضرات المنتمية الى مساق معين
    public ArrayList<Lecture> getLecturesList() {
        return lecturesList;
    }

    public void setLecturesList(ArrayList<Lecture> lecturesList) {
        this.lecturesList = lecturesList;
    }

    public String getCourseDoctor() {
        return courseDoctor;
    }

    public void setDoctor(String courseDoctor) {
        this.courseDoctor = courseDoctor;
    }

    public int getMaximumAbsence() {
        return maximumAbsence;
    }

    public void setMaximumAbsence(int maximumAbsence) {
        this.maximumAbsence = maximumAbsence;
    }

    @Override
    public String toString() {
        return "Course{" +
                "doctor='" + courseDoctor + '\'' +
                ", courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseHours=" + courseHours +
                ", book='" + book + '\'' +
                ", description='" + description + '\'' +
                ", maximumAbsence=" + maximumAbsence +
                ", studentsList=" + studentsList +
                ", lecturesList=" + lecturesList +
                '}';
    }

}
