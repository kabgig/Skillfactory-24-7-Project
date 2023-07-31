package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.entities.StudyProfile;
import org.example.entities.University;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.example.Lgr.logger;

public class UniversityReader {
    List<University> universityList = new ArrayList<>();
    public List<University> readInfo() {
        try (var stream = new FileInputStream("src/main/resources/universityInfo.xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet = workbook.getSheet("Университеты");
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            while (iterator.hasNext()) {
                var row = iterator.next();
                universityList.add(new University.Builder()
                        .setFullName(row.getCell(1).getStringCellValue())
                        .setId(row.getCell(0).getStringCellValue())
                        .setShortName(row.getCell(2).getStringCellValue())
                        .setYearOfFoundation((int) row.getCell(3).getNumericCellValue())
                        .setMainProfile(StudyProfile.valueOf(row.getCell(4).getStringCellValue()))
                        .build());
            }
        } catch (IOException e) {
            logger.severe("Exception " + e);
            throw new RuntimeException(e);
        }
        logger.info("universityList is created and returned");
        return universityList;
    }
}
