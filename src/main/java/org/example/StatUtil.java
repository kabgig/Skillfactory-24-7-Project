package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        for (var uni : universityList) {
            statistics.stream()
                    .filter(st -> st.getMainProfile().equals(uni.getMainProfile()))
                    .findFirst()
                    .ifPresent(st -> addUniAndStudentToStat(uni, st, studentList));
        }
        return statistics;
    }

    public void addUniAndStudentToStat(University uni, Statistics st, List<Student> studentList) {

        List<Student> filteredStudents = studentList
                .stream()
                .filter(student -> student.getUniversityId().equals(uni.getId()))
                .collect(Collectors.toList());

        float averageScore = 0;
        if (!filteredStudents.isEmpty()) {
            averageScore = filteredStudents
                    .stream()
                    .map(student -> student.getAvgExamScore())
                    .reduce((a, b) -> Float.sum(a, b))
                    .get() / (float) filteredStudents.size();
        }

        st.setAmountOfStudentsOnProfile(st.getAmountOfStudentsOnProfile() + filteredStudents.size());
        st.addToAvgExamScore(averageScore);
        st.setAmountOfUniversitiesOnProfile(st.getAmountOfUniversitiesOnProfile() + 1);
        st.getUniversityNames().add(uni.getFullname());
    }
}
