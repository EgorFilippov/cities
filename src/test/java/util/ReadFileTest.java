package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReadFileTest {

    @Test
    void read() {
        String expectedString = "Гадюкино,Московская область,Центральный федеральный округ,100000,1720;Новосибирск,Новосибирская область,Сибирский федеральный округ,1200000,1820;";
        String actualString = ReadFile.read("./src/test/java/util/testFile.txt");
        Assertions.assertEquals(expectedString, actualString);
    }
}