package com.studentsattendance.models;

import java.io.*;

public class DataModel {

    private static Administrator administrator;
    private static TeacherAssistant teacherAssistant;


    public DataModel() {
        initialize();
    }

    public static void initialize(){
        administrator = null;
        try (FileInputStream fis = new FileInputStream(new File("src/main/java/com/studentsattendance/models/Files/admin.bin"))) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                administrator = (Administrator) ois.readObject();
            } catch (Exception e) {

            }
        } catch (Exception e) {

        }
    }

    public void save_date(){
        try(FileOutputStream fos = new FileOutputStream(new File("src/main/java/com/studentsattendance/models/Files/admin.bin"))){
                try(ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(administrator);
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(FileOutputStream fos1 = new FileOutputStream(new File("src/main/java/com/studentsattendance/models/Files/adminRecovery.bin"))){
            try(ObjectOutputStream oos1 = new ObjectOutputStream(fos1)) {
                oos1.writeObject(administrator);
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void loadRecoveryFile() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/main/java/com/studentsattendance/models/Files/adminRecovery.bin"));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("src/main/java/com/studentsattendance/models/Files/admin.bin")));
        while(in.available() > 0) {
            byte[] bytes = in.readNBytes(in.available());
            out.write(bytes);
            out.flush();
        }
    }

    public static Administrator getAdministrator() {
        return administrator;
    }

    public static void setAdministrator(Administrator administrator) {
        DataModel.administrator = administrator;
    }

    public static TeacherAssistant getTeacherAssistant() {
        return teacherAssistant;
    }

    public static void setTeacherAssistant(TeacherAssistant teacherAssistant) {
        DataModel.teacherAssistant = teacherAssistant;
    }
}
