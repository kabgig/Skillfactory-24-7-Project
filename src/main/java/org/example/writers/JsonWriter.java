package org.example.writers;

import org.example.JsonUtil;
import org.example.Root;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.example.Lgr.logger;
import static org.example.writers.WriteToFile.writeToFile;

public class JsonWriter {
    public void write (Root root){
        String result = "";

        List<String> studentJsons = root.getStudentList()
                .stream()
                .map(student -> JsonUtil.serializeStudent(student))
                //.peek(System.out::println)
                .toList();

        List<String> universityJsons = root.getUniversitiesInfo()
                .stream()
                .map(uni -> JsonUtil.serializeUniversity(uni))
                //.peek(System.out::println)
                .toList();


        for(var i : studentJsons){
            result += i;
        }
        for(var i : universityJsons){
            result += i;
        }

        logger.info("Data is serialized");
        String s = LocalDate.now().toString();
        String filePath = "jsonReqs/req_" + s + ".json";
        try {
            writeToFile(result, filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
