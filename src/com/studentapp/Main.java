package com.studentapp;

public class Main {
    public static void main(String[] args) {
        System.out.println("************* Student Management System *************");
        System.out.println("************* Welcome *************");

        Student s1;
        s1 = new Student("Meera", 28, "S-10");
        s1.enrollCourse("Java");
        s1.enrollCourse("Devops");
//        System.out.println(s1);//invoked the toString() method
        s1.printStudentInfo();

        Student s2 = new Student("Kishore", 32, "S-12");
        s2.enrollCourse("DSA");
        s2.enrollCourse("Devops");
//        System.out.println(s2);
        s2.printStudentInfo();

        Student s3 = new Student("Neelakandan", 21, "S-14");
        s3.enrollCourse("Java");
        s3.enrollCourse("Devops");
        s3.enrollCourse("DSA");
//        System.out.println(s3);
        s3.printStudentInfo();

    }
}
