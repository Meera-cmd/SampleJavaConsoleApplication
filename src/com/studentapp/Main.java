package com.studentapp;

import java.util.*;

public class Main {
    private static List<Student> studentList;
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("************* Student Management System *************");
        studentList = new ArrayList<Student>();
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an Option ....");
            System.out.println("1. Register a student");
            System.out.println("2. Find student with student id");
            System.out.println("3. List all student information");
            System.out.println("4. List student information in sorted order");
            System.out.println("5. Exit");
            int option = scanner.nextInt();
            System.out.println("************* Welcome *************");
            switch (option) {
                case 1:
                    enrollStudent(scanner);
                    break;
                case 2:
                    findStudentById(scanner);
                    break;
                case 3:
                    printAllStudentData();
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid option selected");

            }


        }
    }

    private static void exit() {
        System.out.println("Good Bye!!!!");
        System.out.println(0);
    }

    private static void printAllStudentData() {
        if (studentList.size() > 0) {

            System.out.println("------------- PRINTING All Student Data -------------");
            for (Student student : studentList) {
                student.printStudentInfo();
            }
            System.out.println("------------- *************** -------------");
        } else {
            System.err.println("student List is empty!!! No student record found");
        }
    }

    private static void findStudentById(Scanner scanner2) {
        Student studentFound = null;//Explicit initialisation
        System.out.println("Enter the student id ");
        String studentId = scanner2.next();
        try {
            studentFound = studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId)).findFirst()
                    .orElseThrow(() -> new RuntimeException("No data found !!!"));//x.getStudentId() : here student id will be visible in the suggestion if the getter method is implemented
            //This will check if the studentId we entered is present in the student list(x.getStudentId()) and find the first match
            //If its not present in the student list then throws a runtime exception
        } catch (RuntimeException e) {
            System.err.println("No data found !!!");
        }
        studentFound.printStudentInfo();
    }

    private static void enrollStudent(Scanner scanner2) {
        System.out.println("Enter Student name ");
        String studentName = scanner2.next();

        System.out.println("Enter Student age ");
        int studentAge = scanner2.nextInt();

        System.out.println("Enter Student id ");
        String studentId = scanner2.next();

        Student newStudent = new Student(studentName, studentAge, studentId);
        studentList.add(newStudent);

        while (true) {
            System.out.println("Enter the course to be enrolled!!...Type Done to exit");
            String courseName = scanner2.next();
            if (courseName.equalsIgnoreCase("done")) {
                break;
            }
            newStudent.enrollCourse(courseName);
        }
        newStudent.printStudentInfo();

    }


    public static Student findStudentById(String studentId) {
        Student result = null;//Explicit initialisation
        try {
            result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
                    .orElseThrow(() -> new RuntimeException("No data found !!!"));//x.getStudentId() : here student id will be visible in the suggestion if the getter method is implemented
            //This will check if the studentId we entered is present in the student list(x.getStudentId()) and find the first match
            //If its not present in the student list then throws a runtime exception
        } catch (RuntimeException e) {
            System.err.println("No data found !!!");
        }
        return result;
    }

    public static void sortByName() {
       /* Comparator<Student> studentComparator=new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.getName().compareTo(o2.getName())); // compare the names lexographically(alphabetical order)
            }
        };*/
        Comparator<Student> studentComparator = Comparator.comparing(Student::getName);
        Collections.sort(studentList, studentComparator);
        printAllStudentData();
    }

}
