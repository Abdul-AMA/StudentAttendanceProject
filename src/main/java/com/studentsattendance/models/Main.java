package com.studentsattendance.models;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {


        Administrator administrator = new Administrator("admin","admin", "aboodabuamouna@gmail.com");
        Course course1 = new Course("ECOM2450","Digital Design","ayman", 4,"moris manos","logic design");
        Course course2 = new Course("ECOM2412","Programming","ayman",
                4,"yang","OOP programing");
        Course course3 = new Course("EELE2304","Electronics","ayman",
                3,"razavi","semiconductor and diode and transistor");

        administrator.addCourse(course1);
        administrator.addCourse(course2);
        administrator.addCourse(course3);

        TeacherAssistant teacher1 = new TeacherAssistant("mahmoud","code123","mahmoud","haddad","haddad@gmail.com",course1);
        TeacherAssistant teacher2 = new TeacherAssistant("ahmed","code1234","ahmed","tar","ahmed@gmail.com",course2);
        TeacherAssistant teacher3 = new TeacherAssistant("osama","code12345","osama","hab","osama@gmail.com",course3);

        administrator.addTeacher(teacher1);
        administrator.addTeacher(teacher2);
        administrator.addTeacher(teacher3);


        ArrayList<Student> studentsCourse1 = new ArrayList<Student>();
        for (int i = 0; i < 5; i++) {
            studentsCourse1.add(new Student("1student"+i,"1student"+i,"1student",""+i,"1student"+i,"computer",i));
        }

        course1.setStudentsList(studentsCourse1);

        ArrayList<Student> studentsCourse2 = new ArrayList<Student>();
        for (int i = 0; i < 5; i++) {
            studentsCourse2.add(new Student("2student"+i,"2student"+i,"2student",""+i,"2student"+i,"computer",i));
        }

        course2.setStudentsList(studentsCourse2);

        ArrayList<Student> studentsCourse3 = new ArrayList<Student>();
        for (int i = 0; i < 5; i++) {
            studentsCourse3.add(new Student("3student"+i,"3student"+i,"3student",""+i,"3student"+i,"electric",i));
        }

        course3.setStudentsList(studentsCourse3);

        course3.getStudentsList().add(new Student("ali","ali","ali","ali","ali","ali",1));

        System.out.println(teacher1.getCourse().getCourseId());

        Lecture lecture  = new Lecture ("firstOne","K415",1.5,new Date());
        teacher1.getCourse().addLecture(lecture);
        teacher1.markAttendance(lecture,course1.getStudentByPhoneNumber(2));
        teacher1.markAttendance(lecture,course1.getStudentByPhoneNumber(1));
        System.out.println(teacher1.getCourse().getLecturesList().size());//
        for (int i = 0; i < lecture.getAttendanceList().size(); i++) {
        }
        System.out.println(course1.getLectureAttendanceNumber(lecture));
        System.out.println(teacher1.getCourse().getAttendanceAndAbsenceStatements(lecture));

        System.out.println(teacher1.getCourse().getFailureStudents());
        System.out.println(teacher1.getCourse().getAttendancesByTitle("firstOne"));
        System.out.println(teacher1.getCourse().getStudentStatistics(course1.getStudentByPhoneNumber(1)));
        System.out.println(teacher1.getCourse().getStudentAttendantLectures(course1.getStudentByPhoneNumber(1)));


        try(FileOutputStream fos = new FileOutputStream(new File("src/main/java/com/studentsattendance/models/Files/admin.bin"))){
            try(ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(administrator);
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//////////////////////////////
//        Administrator administrator = null;
//        try (FileInputStream fis = new FileInputStream(new File("src/main/java/com/studentsattendance/models/Files/admin.bin"))) {
//            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
//                administrator = (Administrator) ois.readObject();
//            } catch (Exception e) {
//
//            }
//        } catch (Exception e) {
//
//        }
//        System.out.println(administrator);
//        System.out.println(administrator.getEmail());
//


    }
}
