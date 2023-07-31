package org.example;

import org.example.entities.Student;
import org.example.entities.University;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.Lgr.logger;

public class StatUtil {
    public List<Statistics> processStats(List<Student> studentList, List<University> universityList) {
        List<Statistics> statistics = new ArrayList<>();

// creating distinct PROFILE statistics
        universityList.stream()
                .map(uni -> uni.getMainProfile())
                .distinct().forEach(profile -> {
                    var st = new Statistics();
                    st.setMainProfile(profile);
                    statistics.add(st);
                });
        logger.info("Distinct PROFILE statistics created");


        for (var uni : universityList) {
            statistics.stream()
                    .filter(st -> st.getMainProfile().equals(uni.getMainProfile()))
                    .findFirst()
                    .ifPresent(st -> addUniAndStudentToStat(uni, st, studentList));
        }
        logger.info("Returning statistics list");
        return statistics;
    }

    public void addUniAndStudentToStat(University uni, Statistics st, List<Student> studentList) {

        List<Student> filteredStudents = studentList
                .stream()
                .filter(student -> student.getUniversityId().equals(uni.getId()))
                .collect(Collectors.toList());
        logger.info("students filtered");

        float averageScore = 0;
        if (!filteredStudents.isEmpty()) {
            averageScore = filteredStudents
                    .stream()
                    .map(student -> student.getAvgExamScore())
                    .reduce((a, b) -> Float.sum(a, b))
                    .get() / (float) filteredStudents.size();
        }
        logger.info("got average score");

        st.setAmountOfStudentsOnProfile(st.getAmountOfStudentsOnProfile() + filteredStudents.size());
        st.addToAvgExamScore(averageScore);
        st.setAmountOfUniversitiesOnProfile(st.getAmountOfUniversitiesOnProfile() + 1);
        st.getUniversityNames().add(uni.getFullname());
        logger.info("University " + uni.getShortName() + " and students added to statistics");
    }
}
