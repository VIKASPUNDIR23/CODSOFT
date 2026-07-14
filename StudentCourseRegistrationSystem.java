import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    int enrolled;
    String schedule;

    Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolled = 0;
    }

    void display() {
        System.out.println(code + " - " + title);
        System.out.println("Description: " + description);
        System.out.println("Schedule: " + schedule);
        System.out.println("Available Seats: " + (capacity - enrolled));
        System.out.println();
    }
}

class Student {
    int id;
    String name;
    ArrayList<Course> registeredCourses = new ArrayList<>();

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void showRegisteredCourses() {
        if (registeredCourses.size() == 0) {
            System.out.println("No courses registered.");
            return;
        }

        System.out.println("Registered Courses:");
        for (Course c : registeredCourses) {
            System.out.println(c.code + " - " + c.title);
        }
    }
}

public class StudentCourseRegistrationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Course> courses = new ArrayList<>();

        courses.add(new Course("C101", "Java", "Java Programming", 2, "Monday"));
        courses.add(new Course("C102", "Python", "Python Programming", 2, "Tuesday"));
        courses.add(new Course("C103", "DBMS", "Database Management", 2, "Wednesday"));

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        Student student = new Student(id, name);

        int choice;

        do {
            System.out.println("\n1. View Courses");
            System.out.println("2. Register Course");
            System.out.println("3. Drop Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (Course c : courses) {
                        c.display();
                    }
                    break;

                case 2:
                    System.out.print("Enter Course Code: ");
                    String code = sc.next();

                    boolean found = false;

                    for (Course c : courses) {

                        if (c.code.equalsIgnoreCase(code)) {

                            found = true;

                            if (student.registeredCourses.contains(c)) {
                                System.out.println("Already Registered.");
                            } else if (c.enrolled < c.capacity) {
                                student.registeredCourses.add(c);
                                c.enrolled++;
                                System.out.println("Course Registered Successfully.");
                            } else {
                                System.out.println("No Seats Available.");
                            }
                        }
                    }

                    if (!found)
                        System.out.println("Course Not Found.");

                    break;

                case 3:
                    System.out.print("Enter Course Code: ");
                    code = sc.next();

                    boolean removed = false;

                    for (int i = 0; i < student.registeredCourses.size(); i++) {

                        Course c = student.registeredCourses.get(i);

                        if (c.code.equalsIgnoreCase(code)) {
                            student.registeredCourses.remove(i);
                            c.enrolled--;
                            removed = true;
                            System.out.println("Course Removed Successfully.");
                            break;
                        }
                    }

                    if (!removed)
                        System.out.println("Course Not Registered.");

                    break;

                case 4:
                    student.showRegisteredCourses();
                    break;

                case 5:
                    System.out.println("Thank You");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }
}