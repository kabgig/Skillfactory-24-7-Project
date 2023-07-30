package org.example;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"id", "fullname" , "mainProfile" })
@XmlRootElement
public class University {

    @SerializedName("University id")
    String id;
    @SerializedName("Full University Name")
    String fullname;
    @SerializedName("Short University name")
    String shortName;
    @SerializedName("Year of foundation")
    int yearOfFoundation;
    @SerializedName("Main Profile")
    StudyProfile mainProfile;

    public University() {
    }

    public static class Builder{
        String id, fullName, shortName;
        int yearOfFoundation;
        StudyProfile mainProfile;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setShortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public Builder setYearOfFoundation(int yearOfFoundation) {
            this.yearOfFoundation = yearOfFoundation;
            return this;
        }

        public Builder setMainProfile(StudyProfile mainProfile) {
            this.mainProfile = mainProfile;
            return this;
        }

        public University build(){
            University university = new University();
            university.fullname = this.fullName;
            university.id = this.id;
            university.mainProfile = this.mainProfile;
            university.shortName = this.shortName;
            university.yearOfFoundation = this.yearOfFoundation;
            return university;
        }
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullname + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }

    // Getters ---------

    @XmlElement(name = "universityId")
    public String getId() {
        return id;
    }

    @XmlElement(name = "universityName")
    public String getFullname() {
        return fullname;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    @XmlElement(name = "universityProfile")
    public StudyProfile getMainProfile() {
        return mainProfile;
    }
}
