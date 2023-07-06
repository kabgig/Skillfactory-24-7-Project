package org.example;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("Student Fullname")
    String fullName;
    @SerializedName("University id")
    String universityId;
    @SerializedName("Current Course")
    int currentCourseNumber;
    @SerializedName("Average Exam Score")
    float avgExamScore;

    public Student() {
    }

    public static class Builder {
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

        public Student build() {
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

    // getters------------------

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }
}





