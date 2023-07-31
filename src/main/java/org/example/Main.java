package org.example;

import org.example.entities.Student;
import org.example.entities.University;
import org.example.writers.JsonWriter;
import org.example.writers.XmlWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.LogManager;

import static org.example.Lgr.logger;

public class Main {
    public static void main(String[] args) {
// LOGS----------
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

// GET STATISTICS----------------
        List<Student> students = new StudentReader().readInfo();
        List<University> universities = new UniversityReader().readInfo();

        StatUtil statUtil = new StatUtil();
        List<Statistics> statistics = statUtil.processStats(students, universities);
        new XlsWriter().generateTable(statistics, "ResultTable.xlsx");

// GENERATING XML & JSON----------------
        Root root = new Root();
        root.setLocalDateTime(LocalDateTime.now());
        root.setStudentList(students);
        root.setUniversitiesInfo(universities);
        root.setStatisticalInfo(statistics);

        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.write(root);

        JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.write(root);
        logger.info("FINISHED SUCCESSFULLY");

        //------------------------

//        System.out.println("""
//        4. В методе main выполнить сериализацию коллекций, вывести получившиеся JSON-строки в консоль.
//                """);
//
//        List<String> studentJsons = new StudentReader()
//                .readInfo()
//                .stream()
//                .map(student -> JsonUtil.serializeStudent(student))
//                .peek(System.out::println)
//                .toList();
//
//        List<String> universityJsons = new UniversityReader()
//                .readInfo()
//                .stream()
//                .map(uni -> JsonUtil.serializeUniversity(uni))
//                .peek(System.out::println)
//                .toList();
//
//
//       // 5. В методе main выполнить десериализацию полученных строк, сохранить результаты в новые коллекции.
//        List<Student> newStudentList = JsonUtil.deSerializeStudentJsons(studentJsons);
//        List<University> newUniversityList = JsonUtil.deSerializeUniversityJsons(universityJsons);
//
//        System.out.println("""
//
//        6. Сравнить количество элементов в исходной и в десериализованной коллекциях, чтобы убедиться, что десериализация выполняется корректно.
//                """);
//        System.out.println("studentJsons: " + studentJsons.size());
//        System.out.println("newStudentList: " + newStudentList.size());
//        System.out.println("universityJsons: " + universityJsons.size());
//        System.out.println("newUniversityList: " + newUniversityList.size());
//
//        System.out.println("""
//
//         7. С помощью Java Stream API выполнить для исходных коллекций сериализацию отдельных элементов.
//         8. Там же внутри стрима выводить получающиеся JSON-строки.
//         9. Там же внутри стрима десериализовывать объекты из полученных JSON-строк.
//         10. Там же внутри стрима выводить десериализованные объекты на печать, чтобы убедиться в корректности операции.
//
//                """);
//
//        new StudentReader()
//                .readInfo()
//                .stream()
//                .map(JsonUtil::serializeStudent) // 7
//                .peek(System.out::println)// 8
//                .map(JsonUtil::deSerializeStudent)// 9
//                .forEach(System.out::println); // 10
//
//        new UniversityReader()
//                .readInfo()
//                .stream()
//                .map(JsonUtil::serializeUniversity)
//                .peek(System.out::println)
//                .map(JsonUtil::deSerializeUniversity)
//                .forEach(System.out::println);
    }
}