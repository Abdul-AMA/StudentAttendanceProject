package com.studentsattendance.models;

import java.io.*;

public class DataModel {

    private static Administrator administrator;

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
    }

    public static Administrator getAdministrator() {
        return administrator;
    }

    public static void setAdministrator(Administrator administrator) {
        DataModel.administrator = administrator;
    }
}
