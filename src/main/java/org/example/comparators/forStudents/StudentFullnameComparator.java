package org.example.comparators.forStudents;

import org.apache.commons.lang3.StringUtils;
import org.example.entities.Student;
import org.example.interfaces.StudentComparatorInterface;

public class StudentFullnameComparator implements StudentComparatorInterface {
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getFullName(),o2.getFullName());
    }
}
