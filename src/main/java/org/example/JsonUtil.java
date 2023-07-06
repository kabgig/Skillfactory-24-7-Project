package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.stream.Stream;

public class JsonUtil {
    private JsonUtil() {
    }

    private static Gson getGson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson;
    }

    //SERIALIZATION------------------

    public static String serializeStudent(Student student){
        return getGson().toJson(student);
    }

    public static String serializeUniversity(University university){
        return getGson().toJson(university);
    }

    public static Stream<String> serializeStudentList(List<Student> students){
        return students.stream().map(student ->serializeStudent(student));
    }

    public static Stream<String> serializeUniversityList(List<University> university){
        return university.stream().map(uni ->serializeUniversity(uni));
    }

    //DESERIALIZATION------------
    public static Student deSerializeStudent(String studentJson){
        return getGson().fromJson(studentJson, Student.class);
    }

    public static University deSerializeUniversity(String uniJson){
        return getGson().fromJson(uniJson, University.class);
    }

    public static List<Student> deSerializeStudentJsons(List<String> studentJsonList){
        return studentJsonList.stream().map(studentJson -> deSerializeStudent(studentJson)).toList();
    }

    public static List<University> deSerializeUniversityJsons(List<String> uniJsonList){
        return uniJsonList.stream().map(uniJson -> deSerializeUniversity(uniJson)).toList();
    }
}
