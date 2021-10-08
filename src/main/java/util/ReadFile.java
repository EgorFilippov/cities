package util;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFile {

    public static String read(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String readString;
            while ((readString = bufferedReader.readLine()) != null) {
                stringBuilder.append(readString);
            }
        } catch (Exception e) {
            System.out.println("Ошибка открытия или чтения файла");
        }
        return stringBuilder.toString();
    }
}
