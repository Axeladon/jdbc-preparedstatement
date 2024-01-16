package project.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public interface QueryReader {
    default String readQueryFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
