package terminalOfControl;

import ticketClassification.Common;
import ticketClassification.Schoolboy;
import ticketClassification.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Controller {
    String string;

    public Controller(String string) {
        this.string = string;
    }

    public boolean control() {
        String json = fileOpen(string).toString();
        System.out.println(json);
        if (string.charAt(0) == 'q' || string.charAt(0) == 'a' || string.charAt(0) == 'z') {
            if (string.charAt(0) == 'q') {
                Student student = new Student();
                student.deserializePerson(json);
                return student.isSuccessful();
            }
            if (string.charAt(0) == 'a') {
                Schoolboy schoolboy = new Schoolboy();
                schoolboy.deserializePerson(json);
                return schoolboy.isSuccessful();
            }
            if (string.charAt(0) == 'z') {
                Common common = new Common();
                Common deserializeCommon = common.deserializePerson(json);
                return deserializeCommon.isSuccessful();
            }
        } else {
            System.err.println("Class not found");
            return false;
        }
        return false;
    }

    private StringBuilder fileOpen(String string) {
        StringBuilder result = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(string);
            int i;
            while ((i = fileInputStream.read()) != -1) {
                result.append((char) i);
            }
        } catch (FileNotFoundException e) {
            /*NOP*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}