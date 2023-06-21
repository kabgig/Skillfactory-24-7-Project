package org.example;

public class Main {
    public static void main(String[] args) {

        var students = new StudentReader().readInfo();
        for (var student : students){
            System.out.println(student);
        }

        System.out.println("---------");

        var uni = new UniversityReader().readInfo();
        for (var university : uni){
            System.out.println(university);
        }
    }
}