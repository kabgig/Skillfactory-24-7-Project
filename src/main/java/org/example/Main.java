package org.example;

public class Main {
    public static void main(String[] args) {
       Student johnSnow = new Student.Builder()
               .setFullName("John Snow")
               .setAvgExamScore(4.0f)
               .setCurrentCourseNumber(1)
               .setUniversityId("ABCD0001")
               .build();
       University berkleeUniversity = new University.Builder()
               .setFullName("Berklee College of Music")
               .setId("U41")
               .setShortName("BCM")
               .setYearOfFoundation(1967)
               .setMainProfile(StudyProfile.MUSIC)
               .build();

        System.out.println(johnSnow);
        System.out.println(berkleeUniversity);
    }
}