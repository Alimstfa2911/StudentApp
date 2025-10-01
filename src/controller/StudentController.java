package controller;

import dao.StudentDAO;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private final StudentDAO dao = new StudentDAO();
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        int choice;
        do {
            System.out.println("\n--- Student Management ----");
            System.out.println("1. Insert Students");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice : ");
            choice = sc.nextInt();

            switch(choice) {
                case 1 -> insertStudent();
                case 2 -> viewStudent();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while( choice != 5);
    }

    public void insertStudent() {
        System.out.print("Enter Name : ");
        String name = sc.next();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        System.out.print("Enter course : ");
        String course = sc.next();

        dao.insert(new Student(name, age, course));
    }

    public void viewStudent() {
        List<Student> students = dao.getAll();
        System.out.println("\nID | Name | Age | Course");
        System.out.println("----------------------");
        students.forEach(System.out::println);
    }

    public void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        System.out.print("Enter New name : ");
        String name = sc.next();
        System.out.print("Enter New Age : ");
        int age = sc.nextInt();
        System.out.print("Enter New Course : ");
        String course = sc.next();

        dao.update(new Student(id, name, age, course));
    }

    public void deleteStudent() {
        System.out.print("Enter Student ID to delete : ");
        int id = sc.nextInt();
        dao.delete(id);
    }
}