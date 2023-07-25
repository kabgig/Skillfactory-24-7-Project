package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class StudentReader {
    private static final Logger logger = Logger.getLogger(StudentReader.class.getName());

    List<Student> studentList = new ArrayList<>();
    public List<Student> readInfo() {
        try (var stream = new FileInputStream("src/main/resources/universityInfo.xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet = workbook.getSheet("Студенты");
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            while (iterator.hasNext()) {
                var row = iterator.next();
                studentList.add(new Student.Builder()
                        .setFullName(row.getCell(1).getStringCellValue())
                        .setAvgExamScore((float)row.getCell(3).getNumericCellValue())
                        .setCurrentCourseNumber((int)row.getCell(2).getNumericCellValue())
                        .setUniversityId(row.getCell(0).getStringCellValue())
                        .build());
            }
        } catch (IOException e) {
            logger.severe("Exception " + e);
            throw new RuntimeException(e);
        }
        logger.info("studentList created and returned");
        return studentList;
    }
}
