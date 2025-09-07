package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
    private static List<Student> studentList;

    public static void main(String[] args) {
        System.out.println("************* Student Management System *************");
        System.out.println("************* Welcome *************");
        studentList = new ArrayList<Student>();
        Student s1;
        s1 = new Student("Meera", 28, "S-10");
        s1.enrollCourse("Java");
        s1.enrollCourse("Devops");


        Student s2 = new Student("Kishore", 32, "S-12");
        s2.enrollCourse("DSA");
        s2.enrollCourse("Devops");


        Student s3 = new Student("Neelakandan", 21, "S-14");
        s3.enrollCourse("Java");
        s3.enrollCourse("Devops");
        s3.enrollCourse("DSA");

        Student s4 = new Student("Arav", 21, "S-15");
        s4.enrollCourse("Java");
        s4.enrollCourse("Devops");
        s4.enrollCourse("DSA");

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        Student result = findStudentById("s-10");
        System.out.println("Result : " + result);
        sortByName();

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
