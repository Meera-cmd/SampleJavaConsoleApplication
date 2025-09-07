package com.studentapp;

import java.util.*;

public class Main3 {
    private static List<Student> studentList;

    public static void main(String[] args) {
        System.out.println("************* Student Management System *************");
        System.out.println("************* Welcome *************");
        studentList = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the student name ...");
        String name = scanner.next(); // to read string values use next()
        System.out.println("The student name is " + name);

        System.out.println("Enter the student age ...");
        int age = scanner.nextInt(); // to read string values use nextInt()
        System.out.println("The student name is " + age);

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
        System.out.println(studentList);
    }

}
