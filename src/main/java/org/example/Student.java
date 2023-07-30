package org.example;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"fullName", "universityId" , "avgExamScore" })
@XmlRootElement
public class Student extends Entity {
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
            student.fullName = this.fullName;
            student.universityId = this.universityId;
            student.avgExamScore = this.avgExamScore;
            student.currentCourseNumber = this.currentCourseNumber;
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

    @XmlElement(name = "studentName")
    public String getFullName() {
        return fullName;
    }

    @XmlElement(name = "universityId")
    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    @XmlElement(name = "avgScore")
    public float getAvgExamScore() {
        return avgExamScore;
    }
}





