package com.ocado;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class AsteriskTest {
    @Test
    void isValid() throws IOException {
        String fileName = "src/test/java/com/ocado/asteriskData.json";
        String fileContents = new String(Files.readAllBytes(Paths.get(fileName)));
        assertFalse(Asterisk.verifyIAMRolePolicy(fileContents));
    }

    @Test
    void isValid2() throws IOException {
        String fileName = "src/test/java/com/ocado/asteriskData2.json";
        String fileContents = new String(Files.readAllBytes(Paths.get(fileName)));
        assertTrue(Asterisk.verifyIAMRolePolicy(fileContents));
    }
}