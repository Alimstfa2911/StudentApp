package controller;

import dao.StudentDAO;
import model.Student;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private final StudentDAO dao = new StudentDAO();
    private final Scanner sc = new Scanner(System.in);

    private StudentService studentService = new StudentService();

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
        try {
            System.out.print("Enter Name : ");
            String name = sc.next();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            System.out.print("Enter course : ");
            String course = sc.next();

            Student student = new Student(name, age, course);

            studentService.addStudent(student);

            System.out.println("Student added successfully!");

        } catch(Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        
    }

    public void viewStudent() {
        List<Student> students = dao.getAll();
        System.out.println("\nID | Name | Age | Course");
        System.out.println("----------------------");
        students.forEach(System.out::println);
    }

    public void updateStudent() {
        try {
            System.out.print("Enter Student ID to update: ");
            int id = sc.nextInt();
            System.out.print("Enter New name : ");
            String name = sc.next();
            System.out.print("Enter New Age : ");
            int age = sc.nextInt();
            System.out.print("Enter New Course : ");
            String course = sc.next();

            Student student = new Student(id, name, age, course);

            studentService.updateStudent(student);
        } catch(Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        
    }

    public void deleteStudent() {
         try {
            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();

            studentService.deleteStudent(id);

            System.out.println(" Student deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}