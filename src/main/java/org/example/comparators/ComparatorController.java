package org.example.comparators;

import org.example.entities.Student;
import org.example.entities.University;
import org.example.comparators.forStudents.StudentAvgExamScoreComparator;
import org.example.comparators.forStudents.StudentCurrentCourseNumberComparator;
import org.example.comparators.forStudents.StudentFullnameComparator;
import org.example.comparators.forStudents.StudentUniversityIdComparator;
import org.example.comparators.forUniversities.*;
import org.example.enums.StudentComparatorsEnums;
import org.example.enums.UniversityComparatorsEnums;

import java.util.Comparator;

public class ComparatorController {
    private ComparatorController() {
    }

    public static Comparator<Student> studentComparatorStarter(StudentComparatorsEnums studentEnumComparator) {
        return switch (studentEnumComparator.toString()) {
            case "FULLNAME" -> new StudentFullnameComparator();
            case "AVG_EXAM_SCORE" -> new StudentAvgExamScoreComparator();
            case "CURRENT_COURSE_NUMBER" -> new StudentCurrentCourseNumberComparator();
            case default -> new StudentUniversityIdComparator();
        };
    }

    public static Comparator<University> universityComparatorStarter(UniversityComparatorsEnums universityEnumComparator) {
        return switch(universityEnumComparator.toString()){
            case "ID" -> new UniversityIdComparator();
            case "FULLNAME" -> new UniversityFullnameComparator();
            case "SHORT_NAME" -> new UniversityShortNameComparator();
            case "YEAR_OF_FOUNDATION" -> new UniversityYearOfFoundationComparator();
            default -> new UniversityMainProfileComparator();
        };
    }
}
