package org.example;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Statistics {
    StudyProfile mainProfile;
    ArrayList<Float> avgExamScore;
    int amountOfStudentsOnProfile;
    int amountOfUniversitiesOnProfile;
    List<String> universityNames;

    public Statistics() {
       this.universityNames = new ArrayList<>();
       this.avgExamScore = new ArrayList<>();
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public float getAvgExamScore() {
        float result = 0;
        for (var i: avgExamScore){
            result += i;
        }
        float valueToRound = result/avgExamScore.size();
        int decimalPlaces = 2;
        BigDecimal bigDecimalValue = new BigDecimal(Float.toString(valueToRound));
        BigDecimal roundedValue = bigDecimalValue.setScale(decimalPlaces, RoundingMode.HALF_EVEN);
        return roundedValue.floatValue();

    }

    public void addToAvgExamScore(Float score) {
        this.avgExamScore.add(score);
    }

    public int getAmountOfStudentsOnProfile() {
        return amountOfStudentsOnProfile;
    }

    public void setAmountOfStudentsOnProfile(int amountOfStudentsOnProfile) {
        this.amountOfStudentsOnProfile = amountOfStudentsOnProfile;
    }

    public int getAmountOfUniversitiesOnProfile() {
        return amountOfUniversitiesOnProfile;
    }

    public void setAmountOfUniversitiesOnProfile(int amountOfUniversitiesOnProfile) {
        this.amountOfUniversitiesOnProfile = amountOfUniversitiesOnProfile;
    }

    public List<String> getUniversityNames() {
        return universityNames;
    }

    public void setUniversityNames(List<String> universityNames) {
        this.universityNames = universityNames;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "mainProfile=" + mainProfile +
                ", avgExamScore=" + getAvgExamScore() +
                ", amountOfStudentsOnProfile=" + amountOfStudentsOnProfile +
                ", amountOfUniversitiesOnProfile=" + amountOfUniversitiesOnProfile +
                ", universityNames=" + universityNames +
                '}' + "\n";
    }
}
