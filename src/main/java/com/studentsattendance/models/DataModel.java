package com.studentsattendance.models;

import java.io.*;

public class DataModel implements Serializable{

    private static Administrator administrator;
    private static TeacherAssistant teacherAssistant;


    public DataModel() {
        initialize();
    }

    public static void initialize() {
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
        String sourceFilePath = "src/main/java/com/studentsattendance/models/Files/adminRecovery.bin"; // Replace with the actual path to the source file
        String destinationFilePath = "src/main/java/com/studentsattendance/models/Files/admin.bin"; // Replace with the actual path to the destination file

        try (FileInputStream inputStream = new FileInputStream(sourceFilePath);
             FileOutputStream outputStream = new FileOutputStream(destinationFilePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }


        } catch (IOException e) {
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
