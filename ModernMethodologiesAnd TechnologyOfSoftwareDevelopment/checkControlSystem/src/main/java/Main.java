import terminalOfControl.Controller;
import ticketClassification.Common;
import ticketClassification.Schoolboy;
import ticketClassification.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu(scanner);
    }

    private static void menu(Scanner scanner) {
        try {
            select(scanner);
        } catch (InputMismatchException e) {
            System.err.println("Invalid number");
            menu(new Scanner(System.in));
        }
    }

    private static void select(Scanner scanner) {
        System.out.println("Select: \n" +
                "1)Check ticket \n" +
                "2)Create ticket \n" +
                "3)Exit");
        int scan = scanner.nextInt();
        if (scan == 1 || scan == 2 || scan == 3) {
            if (scan == 1) {
                firstSelect(scanner);
            }
            if (scan == 2) {
                secondSelect(scanner);
            }
            if (scan == 3) {
                thirdSelect();
            }
        } else {
            System.err.println("Invalid number");
            select(scanner);
        }
    }

    private static void thirdSelect() {
        System.exit(0);
    }

    private static void secondSelect(Scanner scanner) {
        try {
            create(scanner);
        } catch (InputMismatchException e) {
            System.out.println("Invalid number");
            create(new Scanner(System.in));
        }
        menu(scanner);
    }

    private static void firstSelect(Scanner scanner) {
        try {
            check();
        } catch (InputMismatchException e) {
            System.out.println("Invalid number");
            check();
        }
        menu(scanner);
    }

    private static void check() {
        System.out.print("input file name:");
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(scanner.nextLine());
        boolean successful = controller.control();
        if (successful) {
            System.out.println("\u001B[32m" + "SUCCESSFUL!!!" + "\u001B[0m");
        } else {
            System.out.println("\u001B[31m" + "FAIL!!!" + "\u001B[0m");
        }
    }

    private static void create(Scanner scanner) {
        System.out.println("Select: \n" +
                "1)Student ticket creating \n" +
                "2)Schoolboy ticket creating \n" +
                "3)Common ticket creating");
        int scan = scanner.nextInt();
        if (scan == 1 || scan == 2 || scan == 3) {
            if (scan == 1) {
                creatingStudent();
            }
            if (scan == 2) {
                creatingSchoolboy();
            }
            if (scan == 3) {
                creatingCommon();
            }
        } else {
            System.err.println("Invalid number");
            select(scanner);
        }
    }

    private static void creatingCommon() {
        Common common = new Common();
        try {
            common.setCommon();
            writeCommonToFile(common);
        } catch (InputMismatchException e) {
            System.err.println("Invalid number");
            common.setCommon();
        } catch (IOException e) {
            /*NOP*/
        }
    }

    private static void writeCommonToFile(Common common) throws IOException {
        String json = common.serializePerson();
        FileWriter fileWriter = new FileWriter("z" + common.getId() + ".json");
        fileWriter.write(json);
        fileWriter.flush();
        fileWriter.close();
    }

    private static void creatingSchoolboy() {
        Schoolboy schoolboy = new Schoolboy();
        try {
            schoolboy.setPreferential();
            writeSchoolboyToFile(schoolboy);
        } catch (InputMismatchException e) {
            System.err.println("Invalid number");
            schoolboy.setPreferential();
        } catch (IOException e) {
            /*NOP*/
        }
    }

    private static void writeSchoolboyToFile(Schoolboy schoolboy) throws IOException {
        String json = schoolboy.serializePerson();
        FileWriter fileWriter = new FileWriter("a" + schoolboy.getId() + ".json");
        fileWriter.write(json);
        fileWriter.flush();
        fileWriter.close();
    }

    private static void creatingStudent() {
        Student student = new Student();
        try {
            student.setPreferential();
            writeStudentToFile(student);
        } catch (InputMismatchException e) {
            System.err.println("Invalid number");
            student.setPreferential();
        } catch (IOException e) {
            /*NOP*/
        }
    }

    private static void writeStudentToFile(Student student) throws IOException {
        String json = student.serializePerson();
        FileWriter fileWriter = new FileWriter("q" + student.getId() + ".json");
        fileWriter.write(json);
        fileWriter.flush();
        fileWriter.close();
    }
}