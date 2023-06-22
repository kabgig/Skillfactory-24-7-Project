package org.example;

import org.example.comparators.*;
import org.example.enums.StudentComparatorsEnums;
import org.example.enums.UniversityComparatorsEnums;

public class Main {
    public static void main(String[] args) {

        var studentComparator = ComparatorController
                .studentComparatorStarter
                        (StudentComparatorsEnums.FULLNAME);

        var universityComparator = ComparatorController
                .universityComparatorStarter
                        (UniversityComparatorsEnums.FULLNAME);

        //----------------------------------
        System.out.println("Sorted students----------------\n");
        new StudentReader()
                .readInfo()
                .stream()
                .sorted(studentComparator)
                .forEach(System.out::println);

        System.out.println("Sorted universities------------\n");
        new UniversityReader()
                .readInfo()
                .stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

    }
}