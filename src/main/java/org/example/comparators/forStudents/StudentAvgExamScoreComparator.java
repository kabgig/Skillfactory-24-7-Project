package org.example.comparators.forStudents;

import org.example.Student;
import org.example.interfaces.StudentComparatorInterface;

public class StudentAvgExamScoreComparator implements StudentComparatorInterface {
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o2.getAvgExamScore(),o1.getAvgExamScore());
    }
}
