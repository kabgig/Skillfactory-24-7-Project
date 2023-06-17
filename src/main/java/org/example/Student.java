package org.example;

public class Student {
    String fullName, universityId;
    int currentCourseNumber;
    float avgExamScore;

    public Student() {
    }

    public static class Builder{
        String fullName, universityId;
        int currentCourseNumber;
        float avgExamScore;

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setCurrentCourseNumber(int currentCourseNumber) {
            this.currentCourseNumber = currentCourseNumber;
            return this;
        }

        public Builder setUniversityId(String universityId) {
            this.universityId = universityId;
            return this;
        }

        public Builder setAvgExamScore(float avgExamScore) {
            this.avgExamScore = avgExamScore;
            return this;
        }

        public Student build(){
            Student student = new Student();
            student.avgExamScore = this.avgExamScore;
            student.universityId = this.universityId;
            student.currentCourseNumber = this.currentCourseNumber;
            student.fullName = this.fullName;
            return student;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }
}
