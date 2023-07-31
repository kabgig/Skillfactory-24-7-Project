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
                .map(student -> JsonUtil.serializeEntity(student))
                .toList();
        logger.info("Gathered studentJsons");

        List<String> universityJsons = root.getUniversitiesInfo()
                .stream()
                .map(uni -> JsonUtil.serializeEntity(uni))
                .toList();
        logger.info("Gathered universityJsons");

        List<String> statisticsJsons = root.getStatisticalInfo()
                .stream()
                .map(uni -> JsonUtil.serializeEntity(uni))
                .toList();
        logger.info("Gathered statisticsJsons");

        for(var i : studentJsons){
            result += i;
        }
        for(var i : universityJsons){
            result += i;
        }
        for(var i : statisticsJsons){
            result += i;
        }
        logger.info("All data is serialized");
        String s = LocalDate.now().toString();
        String filePath = "jsonReqs/req_" + s + ".json";
        try {
            writeToFile(result, filePath);
        } catch (IOException e) {
            logger.severe("IOException" + e);
            throw new RuntimeException(e);
        }
    }
}
