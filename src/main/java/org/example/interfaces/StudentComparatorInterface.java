package org.example.interfaces;

import org.example.entities.Student;

import java.util.Comparator;

public interface StudentComparatorInterface extends Comparator<Student> {
    int compare(Student o1, Student o2);
}
