package org.example.comparators.forStudents;

import org.example.Student;
import org.example.interfaces.StudentComparatorInterface;

public class StudentCurrentCourseNumberComparator implements StudentComparatorInterface {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(),o2.getCurrentCourseNumber());
    }
}