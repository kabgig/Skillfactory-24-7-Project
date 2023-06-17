package org.example;

public class University {
    String id, fullName, shortName;
    int yearOfFoundation;
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
            university.fullName = this.fullName;
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
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }
}
