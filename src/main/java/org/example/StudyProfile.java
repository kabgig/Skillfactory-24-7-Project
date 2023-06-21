package org.example;

public enum StudyProfile {

    ENGINEERING("Инжиниринг"),
    MEDICINE("Медицина"),
    PROGRAMMING("Программирование"),
    MUSIC("Музыка"),
    MATHEMATICS("Математика"),
    LINGUISTICS("Лингвистика"),
    PHYSICS("Физика"),
    UNKNOWN("Не задано");

    String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
