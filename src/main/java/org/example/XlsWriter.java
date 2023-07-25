package org.example;

import org.apache.poi.xssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XlsWriter {
    private static final Logger logger = Logger.getLogger(XlsWriter.class.getName());

    public void generateTable(List<Statistics> statisticObjects, String urlToFile) {

        try (XSSFWorkbook workbook = new XSSFWorkbook();
             FileOutputStream fos = new FileOutputStream(urlToFile);
        ) {

//creating sheet and styles
            XSSFSheet sheet = workbook.createSheet("Sheet1");
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            font.setFontName("Arial");
            font.setFontHeight(14);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);
            logger.info("sheet and styles are created");

//creating header
            XSSFRow row1 = sheet.createRow(0);
            XSSFCell cellA = row1.createCell(0);
            XSSFCell cellB = row1.createCell(1);
            XSSFCell cellC = row1.createCell(2);
            XSSFCell cellD = row1.createCell(3);
            XSSFCell cellE = row1.createCell(4);
            cellA.setCellValue("Main Profile");
            cellB.setCellValue("Avg Exam Score");
            cellC.setCellValue("Amount Of Students");
            cellD.setCellValue("Amount Of Universities");
            cellE.setCellValue("University Names");
            logger.info("Header is created");

//setting style
            cellA.setCellStyle(style);
            cellB.setCellStyle(style);
            cellC.setCellStyle(style);
            cellD.setCellStyle(style);
            cellE.setCellStyle(style);
            logger.info("style is set");

//filling table from statistics
            for (int i = 0; i < statisticObjects.size(); i++) {
                XSSFRow rowR = sheet.createRow(i + 1);
                XSSFCell cell1 = rowR.createCell(0);
                XSSFCell cell2 = rowR.createCell(1);
                XSSFCell cell3 = rowR.createCell(2);
                XSSFCell cell4 = rowR.createCell(3);
                XSSFCell cell5 = rowR.createCell(4);
                cell1.setCellValue(statisticObjects.get(i).mainProfile.name());
                cell2.setCellFormula(statisticObjects.get(i).getAvgExamScore() + "");
                cell3.setCellValue(statisticObjects.get(i).amountOfStudentsOnProfile);
                cell4.setCellValue(statisticObjects.get(i).amountOfUniversitiesOnProfile);
                cell5.setCellValue(statisticObjects.stream()
                        .map(st -> st.getUniversityNames())
                        .flatMap(Collection::stream)
                        .collect(Collectors.joining(", ")));
            }
            workbook.write(fos);
            logger.info("Table is filled from statistics");
        } catch (FileNotFoundException e) {
            logger.severe("FileNotFoundException " + e );
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.severe("RuntimeException " + e );
            throw new RuntimeException(e);
        }
    }
}
