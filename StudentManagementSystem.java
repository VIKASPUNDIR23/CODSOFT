import java.io.*;
import java.util.*;

class Student implements Serializable {

    int rollNo;
    String name;
    String grade;
    int age;

    Student(int rollNo, String name, String grade, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    public String toString() {
        return "Roll No: " + rollNo +
                ", Name: " + name +
                ", Grade: " + grade +
                ", Age: " + age;
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent() {

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        students.add(new Student(roll, name, grade, age));

        System.out.println("Student Added");
    }

    static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    static void searchStudent() {

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        for (Student s : students) {

            if (s.rollNo == roll) {
                System.out.println("Student Found:");
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student Not Found");
    }

    static void removeStudent() {

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {

            Student s = it.next();

            if (s.rollNo == roll) {
                it.remove();
                System.out.println("Student Removed");
                return;
            }
        }

        System.out.println("Student Not Found");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\nSTUDENT MANAGEMENT SYSTEM \n");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    removeStudent();
                    break;

                case 5:
                    System.out.println("Program Ended");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);
    }
}
