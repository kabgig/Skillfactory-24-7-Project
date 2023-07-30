package org.example.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.example.Lgr.logger;

public class WriteToFile {
    public static void writeToFile(String data, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent());

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(data);
            logger.info("Data is written to file: " + filePath);
        }
        catch (IOException e) {
            logger.severe("error" + e);
            throw new RuntimeException(e);
        }
    }
}
