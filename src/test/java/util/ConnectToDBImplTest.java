package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

class ConnectToDBImplTest {

    @Test
    void getConnection() {

        try (Connection connection = ConnectToDBImpl.getConnection()) {
            Assertions.assertNotNull(connection);
        } catch (Exception e) {
            //**
        }

    }
}


